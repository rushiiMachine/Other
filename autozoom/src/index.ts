if (process.platform !== "win32") {
  console.error("This can only run on windows");
  process.exit();
}

import fs from "fs";
import cron from "node-cron";
import cp from "child_process";
import openinbrowser from "open";

type TMeeting = {
  name: string;
  url: string;
  id: string;
  days: string;
  hours: string;
  minutes: string;
};

function startMeeting(m: TMeeting) {
  if (m.id && m.id !== "")
    cp.spawn(
      process.env.APPDATA + "\\Zoom\\bin\\Zoom.exe",
      [`--url=zoommtg://zoom.us/join?action=join&confno=${m.id}`],
      { detached: true, stdio: ["ignore"] }
    ).unref();

  if (m.url && m.url !== "") openinbrowser(m.url);
}

fs.readFile("../config/meetings.json", "utf8", (err, contents) => {
  if (err) return console.error(err);
  let meetings: TMeeting[];
  try {
    meetings = JSON.parse(contents);
  } catch (error) {
    console.error(error);
    console.error(
      "Your meetings.json is not a valid JSON file. Please fix the syntax errors"
    );
  }
  meetings.forEach((m: TMeeting) => {
    const cronTime = `0 ${m.minutes.replace(" ", "")} ${m.hours.replace(" ", "")} * * ${m.days.replace(" ", "")}`;
    cron.schedule(cronTime, () => startMeeting(m));
  });
});
