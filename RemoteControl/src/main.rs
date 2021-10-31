use std::convert::Infallible;
use std::net::SocketAddr;
use std::process::Command;

use hyper::{Body, Request, Response, Server, StatusCode};
use hyper::service::{make_service_fn, service_fn};

fn lock() -> bool {
    unsafe { winapi::um::winuser::LockWorkStation() != 0 }
}

fn sleep() -> bool {
    unsafe { winapi::um::powrprof::SetSuspendState(0, 0, 0) != 0 }
}

fn shutdown() -> bool {
    let mut cmd = Command::new("shutdown.exe /s");
    !cmd.output().is_err()
}

fn logoff() -> bool {
    let mut cmd = Command::new("shutdown.exe /l");
    !cmd.output().is_err()
}

async fn handle(req: Request<Body>) -> Result<Response<Body>, Infallible> {
    match req.uri().path() {
        "/" => Ok(Response::new("online".into())),
        "/lock" => Ok(Response::new(lock().to_string().into())),
        "/sleep" => Ok(Response::new(sleep().to_string().into())),
        "/shutdown" => Ok(Response::new(shutdown().to_string().into())),
        "/logoff" => Ok(Response::new(logoff().to_string().into())),
        _ => {
            Ok(Response::builder()
                .status(StatusCode::NOT_FOUND)
                .body("Not Found".into())
                .unwrap())
        }
    }
}

#[tokio::main]
async fn main() {
    let addr = SocketAddr::from(([127, 0, 0, 1], 7000));

    let make_svc = make_service_fn(|_conn| async {
        Ok::<_, Infallible>(service_fn(handle))
    });

    let server = Server::bind(&addr).serve(make_svc);

    if let Err(e) = server.await {
        eprintln!("server error: {}", e);
    }
}
