use std::time::Duration;
use msgbox::IconType;

// https://stackoverflow.com/a/29764309/13964629
fn hide_console_window() {
    use std::ptr;
    use winapi::um::wincon::GetConsoleWindow;
    use winapi::um::winuser::{ShowWindow, SW_HIDE};

    let window = unsafe {GetConsoleWindow()};
    // https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-showwindow
    if window != ptr::null_mut() {
        unsafe {
            ShowWindow(window, SW_HIDE);
        }
    }
}

fn main() {
    hide_console_window();
    msgbox::create("the varus", "deleting the blackmail from ur mom", IconType::Info);
    std::thread::sleep(Duration::from_secs(3));
    msgbox::create("ur mom", "nah im jsut fuking wtih yuo this doens tdo anytihgn LOL", IconType::Error);
}
