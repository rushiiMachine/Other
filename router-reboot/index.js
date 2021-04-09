const fetch = require('node-fetch');
const cron = require('cron').CronJob;
require('dotenv').config();

const auth = `Basic ${Buffer.from(process.env.ROUTER_USER + ':' + process.env.ROUTER_PASSWORD).toString('base64')}`;
const body = `buttonSelect=2&wantype=static&wanifname=eth0&wan_status=up&enable_apmode=0&wwan_wan_type=1&wwan_IMSI=&wwan_IMEI=&USER_SET_TOKEN=101c0b85d9472735412f`;

async function reset() {
  await fetch(process.env.ROUTER_ADDRESS + '/newgui_adv_home.cgi', {
    method: 'POST',
    body: body,
    headers: {
      Authorization: auth,
      'Content-Type': 'application/x-www-form-urlencoded',
    },
  });
  console.log('Reset router');
}

reset();

const job = new cron('0 0 * * *', reset, null, true, 'America/Los_Angeles');
job.start();
