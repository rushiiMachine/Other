const {
  Client
} = require("discord.js");
const config = require("./config.json");

var clients = [
  new Client(), new Client(), new Client(), new Client(), new Client(),
  new Client(), new Client(), new Client(), new Client(), new Client(),
  new Client(), new Client(), new Client(), new Client(), new Client(),
  new Client(), new Client(), new Client(), new Client(), new Client()
]

if (process.platform === "win32") {
  var rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
  });
  rl.on("SIGINT", function() {
    process.emit("SIGINT");
  });
}
process.on("SIGINT", () => {
  for (index in clients) {
    clients[index].destroy();
  }
  process.exit();
});

for (index in clients) {
  clients[index].on("message", async message => {
    if (message.author.bot) return;
    if (message.content.indexOf(config.prefix) !== 0) return;
    const args = message.content.slice(config.prefix.length).trim().split(/ +/g);
    const command = args.shift().toLowerCase();

    if (command === `say`) {
      const quantity = args.shift();
      if (quantity <= 100) {
        for (i = 0; i < quantity; i++) {
          message.channel.send(args.join(" "));
        }
      }
    }
  });
}

for (index in clients) {
  clients[index].login(config[`bot${Number(index) + 1}_token`]).catch(err => console.log(err.message));
}
