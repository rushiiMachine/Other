//ISDBot Authroization URL: https://discordapp.com/oauth2/authorize?&client_id=676531804827549702&scope=bot&permissions=8

const Discord = require("discord.js");
const mysql = require('mysql');
const fs = require('fs');
const snoowrap = require('snoowrap');
const config = require("./config.json");
const client = new Discord.Client();
const pfx = config.prefix;
var sqlcon = mysql.createConnection({host: config.host, user: config.user, password: config.password, database: config.database, charset : 'utf8mb4'});
var outputChannel; //Assigned when bot is ready
var staffRole; //Assigned when bot is ready

sqlcon.connect(function(err) {
  if (err) throw err;
  console.log("Connection successful to SQL DB");
});

const reddit = new snoowrap({
  userAgent: config.reddit_user_agent,
  clientId: config.reddit_client_id,
  clientSecret: config.reddit_client_secret,
  username: config.reddit_username,
  password: config.reddit_password,
});

// Run on exit
if (process.platform === "win32") {
  var rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
  });

  rl.on("SIGINT", function () {
    process.emit("SIGINT");
  });
}
process.on("SIGINT", function () {
  console.log(`Exiting...`);
  client.destroy();
  process.exit();
});

client.on("ready", () => {
  console.log(`Bot has started, with ${client.users.size} users, in ${client.channels.size} channels of ${client.guilds.size} guilds.`);
  outputChannel = client.channels.find(channel => channel.name === 'bot-output');
  staffRole = outputChannel.guild.roles.find(role => role.name === 'STAFF');

  // Get current length of this file and use it for the activity
  lines = countFileLines(__filename).then(value => {
    client.user.setActivity(`${value} lines of code | ${pfx}help`);
  });
});

client.on("guildMemberAdd", member => {
  updateMember(member);
  addusertocounters(member);
});

client.on("guildMemberRemove", member => {
  channel = member.guild.channels.find(channel => channel.name === 'welcome-leave');
  channel.send(`\`${member.user.tag}\` has left the server.`);
});

client.on("message", async message => {
  if(message.author.bot) return;

  addMessage(message);

  if (message.content.toLowerCase().includes(`michael reeves`)) {
    message.channel.send("u fucking crackhead\nhttps://i.imgur.com/vBmSvUr.png");
  }

  if (message.content.toLowerCase().includes(`sex`)) {
    message.channel.send("https://www.youtube.com/watch?v=VfCYZ3pks48");
  }

  if (message.content.toLowerCase().includes(`lmao`) && !message.content.toLowerCase().includes(`lmaocounter`) && !message.content.toLowerCase().includes('lmaolist') || message.content.toLowerCase().includes(`lmfao`)) {
    sql = `SELECT lmao_counter FROM counters WHERE user_id='${message.author.id}';`
    sqlcon.query(sql, function (err, result) {
      if (err) throw err;
      if (result[0] !== undefined) {
        let amnt = Number(result[0].lmao_counter) + 1;
        sql2 = `UPDATE \`isdbot\`.\`counters\` SET \`lmao_counter\` = '${amnt}' WHERE (\`user_id\` = '${message.author.id}');`
        sqlcon.query(sql2, function (err, result) {
          if (err) throw err;
        });
      }
    });
  }

  if (message.content.toLowerCase().includes(`fuck`) && !message.content.toLowerCase().includes(`fuckcounterlist`)) {
      sql = `SELECT fuck_wordcounter FROM counters WHERE user_id='${message.author.id}';`
      sqlcon.query(sql, function (err, result) {
      if (err) throw err;
      if (result[0] !== undefined) {
        let amnt = Number(result[0].fuck_wordcounter) + 1;
        sql2 = `UPDATE counters SET fuck_wordcounter = ${amnt} WHERE user_id = '${message.author.id}';`
        sqlcon.query(sql2, function (err, result) {
          if (err) throw err;
        });
      }
    });
  }

  if (message.content.toLowerCase().includes(`shit`) && !message.content.toLowerCase().includes(`shitcounterlist`)) {
      sql = `SELECT shit_wordcounter FROM counters WHERE user_id='${message.author.id}';`
      sqlcon.query(sql, function (err, result) {
      if (err) throw err;
      if (result[0] !== undefined) {
        let amnt = Number(result[0].shit_wordcounter) + 1;
        sql2 = `UPDATE counters SET shit_wordcounter = ${amnt} WHERE user_id = '${message.author.id}';`
        sqlcon.query(sql2, function (err, result) {
          if (err) throw err;
        });
      }
    });
  }

  var weebAliases = ['weeb','weeabo','wee b','w e e b','w eeb','weeab o','we_eb','weeeb','weeeeb','w_eeb','w e eb','wee  b', 'weebs'];
  for(var index = 0; index < weebAliases.length; index++) {
    if (message.content.toLowerCase().includes(weebAliases[index])) {
      message.delete();
      return;
    }
  }

  if (message.content.toLowerCase() === 'suicide' || message.content.toLowerCase() === 'kill yourself' || message.content.toLowerCase() === 'kill myself' || message.content.toLowerCase() === 'kill urself') {
    let embededmsg = {color: 0xFF0000,title: 'Suicide mentioning alert',fields: [{name: message.author.tag,value: message.content}],timestamp: new Date(),footer: {text: 'ISDBot',icon_url: client.user.avatarURL}};
    client.users.get('295190422244950017').send({embed: embededmsg}); //send me an alert
  }

  if(message.content.indexOf(pfx) !== 0) return; // Skip any messages that dont include the prefix at the front

  const args = message.content.slice(pfx.length).trim().split(/ +/g);
  const command = args.shift().toLowerCase();

  if (command === "help") {
    let embed = {color:0x0099ff, title:'Commands', fields:[{ name:`Commands available:`, value:`\`${pfx}help\` => Displays this help message\n\`${pfx}ping\` => Pong & Latency\n\`${pfx}say [message]\` => Make the bot say the [message]\n\`${pfx}verify\` => Do the verification test\n\`${pfx}updateroles\` => Updates Roles based on info in the database\n\`${pfx}report [mention a user] [reason]\` => report someone to staff **ABUSE WILL NOT BE TOLERATED**\n\`${pfx}name [mention a user]\` => Provides real life name if stored in database\n\`${pfx}namelist\` => Lists everyone's name thats in the database\n\`${pfx}invite\` => Server invite to use when spreading invite slips\n\`${pfx}purge [quantity]\` => Bulk Deletes the quantity of latest messages. __STAFF Only__` },{ name:`Counters:`, value:`\`${pfx}lmaocounterlist [(optional) Mention a user]\` => Lists how many times everyone in the database has said 'lmao' or 'lmfao'\n\`${pfx}fuckcounterlist [(optional) Mention a user]\` => Lists the number of times everyone in the database has said 'fuck'\n\`${pfx}shitcounterlist [(optional) Mention a user]\`=> Lists the number of times everyone in the database has said 'shit'\n` }], timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
    message.channel.send({embed: embed});
  }

  else if(command === "ping") {
    // Calculates ping between sending a message and editing it, giving a nice round-trip latency.
    // The second ping is an average latency between the bot and the websocket server (one-way, not round-trip)
    const m = await message.channel.send("Ping?");
    m.edit(`Pong! Latency is ${m.createdTimestamp - message.createdTimestamp}ms. API Latency is ${Math.round(client.ping)}ms`);
  }

  else if(command === "say") {
    const sayMessage = args.join(" ");
    message.delete();
    message.channel.send(sayMessage);
  }

  else if (command === `verify123`) {
    if (message.channel.type === 'text') {
      client.users.get(message.author.id).send(`==================================================\n__Coded by Tima Ignatov and Berkan Mertan__\nTo get Verified on the ISD Server,\nyou need to complete a Google Form so we can ban if its a person we don't like.\nYour id is \`${message.author.id}\`\nhttps://docs.google.com/forms/d/e/1FAIpQLScNCaByW3-kaD319SAJlk6UO4O2uEIspfsDK2VKBdWkoOSXFA/viewform?usp=pp_url&entry.238992431=${message.author.id}\nWhen you completed it send \`${pfx}updateRoles\` in this direct message.\n==================================================\n`).catch(outputChannel.send(`Could not send verification message to ${message.author.tag}`));
    }
  }

  else if (command === `updateroles`) {
    updateMember(message.member, message);
  }

  else if (command === `report`) {
    let reportedUser = message.guild.member(message.mentions.users.first() || message.guild.members.find(member => member.user.tag === args[0]));
    if (args[0] === undefined) {
      message.channel.send(`You need to mention someone or put their username#discriminator`);
      return;
    }
    if(!reportedUser) {
      message.channel.send('Member not found');
      return;
    }
    let reportReason = args.join(" ").slice(22);
    let reportChannel = message.guild.channels.find(channel => channel.name === 'reports');
    let embededmsg = {color: 0x15f153,title: 'Report',fields: [{name: `Reported User`,value: `<@${reportedUser.id}>`}, {name: `Reported By`, value: `<@${message.author.id}>`}, {name: `Reported in Channel`, value: `<#${message.channel.id}>`}, {name: `Reason`, value: reportReason}],timestamp: new Date(),footer: {text: 'ISDBot',icon_url: client.user.avatarURL}};
    if(!reportChannel) {
       message.channel.send("Could not find reports channel");
       return;
    }
    reportChannel.send({ embed: embededmsg });
    reportChannel.send("@here");
    message.delete();
  }

  else if (command === 'dailymeme') {
    getTopPost(message);
  }

  else if (command === 'namelist') {
    function listFormattedResults(results){
        let toReturn = '';
        results.forEach(result=>{
          toReturn += `<@${result.user_id}> => ${result.name}\n`;
        });
        return toReturn;
    }
    sqlcon.query(`SELECT user_id, name FROM users`, function (err, results) {
      if (err) throw err;
      let embed = {color:0x0099ff, title:'Names', fields:[{ name:`If someone's not in the list, that means they are not in the database`, value: listFormattedResults(results)}], timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
      message.channel.send({embed: embed}).catch(error=>{message.channel.send(`Could not send name info: ${error}`)});
    });
  }

  else if (command === 'lmaocounterlist') {
    function listFormattedResults(results){
        let toReturn = '';
        results.forEach(result=>{
          toReturn += `<@${result.user_id}> => ${Number(result.lmao_counter)}\n`;
        });
        return toReturn;
    }
    sqlcon.query(`SELECT user_id, lmao_counter FROM counters`, function (err, results) {
      if (err) throw err;
      let embed = {color:0x0099ff, title:'How many times people said `lmao`', fields:[{ name:`If someone's not in the list, that means they are not in the database`, value: listFormattedResults(results)}], timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
      message.channel.send({embed: embed}).catch(error=>{message.channel.send(`Could not send lmao counter info: ${error}`)});
    });
  }

  else if (command === 'fuckcounterlist') {
    function listFormattedResults(results){
        let toReturn = '';
        results.forEach(result=>{
          toReturn += `<@${result.user_id}> => ${Number(result.fuck_wordcounter)}\n`;
        });
        return toReturn;
    }
    sqlcon.query(`SELECT user_id, fuck_wordcounter FROM counters`, function (err, results) {
      if (err) throw err;
      let embed = {color:0x0099ff, title:'How many times poeople said `fuck`', fields:[{ name:`If someone's not in the list, that means they are not in the database`, value: listFormattedResults(results)}], timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
      message.channel.send({embed: embed}).catch(error=>{message.channel.send(`Could not send fuck counter info: ${error}`)});
    });
  }


  else if (command === 'shitcounterlist') {
    function listFormattedResults(results){
        let toReturn = '';
        results.forEach(result=>{
          toReturn += `<@${result.user_id}> => ${Number(result.shit_wordcounter)}\n`;
        });
        return toReturn;
    }
    sqlcon.query(`SELECT user_id, shit_wordcounter FROM counters`, function (err, results) {
      if (err) throw err;
      let embed = {color:0x0099ff, title:'How many times poeople said `shit`', fields:[{ name:`If someone's not in the list, that means they are not in the database`, value: listFormattedResults(results)}], timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
      message.channel.send({embed: embed}).catch(error=>{message.channel.send(`Could not send shit counter info: ${error}`)});
    });
  }

  else if (command === 'addusertocounters') {
    let member = message.guild.member(message.mentions.users.first() || message.guild.members.find(member => member.user.tag === args[0]));
    if (args[0] === undefined) {
      message.channel.send(`You need to mention someone or put their username#discriminator`);
      return;
    }
    if(!member) {
      message.channel.send('Member not found');
      return;
    }
    else {
      flag = addusertocounters(member);
      if (flag) {
        message.channel.send(`An error occured`);
      }
      else {
        message.channel.send(`Successfully added ${member.user.tag} into the database or they are already in there`);
      }
    }
  }

  else if (command === 'updateallmembers') {
    members = message.guild.members;
    members.forEach(member => {
      addusertocounters(member);
      updateMember(member);
    });
  }

  else if (command === 'invite') {
    message.channel.send(`https://bit.ly/isdserver`);
  }

  else if (command === 'avatar') {
    let member = message.guild.member(message.mentions.users.first() || message.guild.members.find(member => member.user.tag === args[0]));
    if (args[0] === undefined) {
      message.channel.send(`You need to mention someone or put their username#discriminator`);
      return;
    }
    if(!member) {
      message.channel.send('Member not found');
      return;
    }
    let embed = {color:0x0099ff, title:'Avatar', fields:[{ name:`${member.user.tag}'s Avatar`, value:member.user.avatarURL }], image: {url: member.user.avatarURL}, timestamp:new Date(), footer:{ text:`${message.author.tag} Executed: \`${message.content}\``, icon_url: message.author.avatarURL}};
    message.channel.send({embed: embed});
  }

  else if (command === `purge`) {
    if (message.member.hasPermission('MANAGE_MESSAGES')) {
      amount = parseInt(args[0]);
      if (Number.isNaN(amount)) {
        message.channel.send(`You need to specify a number of messages to delete. MAX 100`);
      }
      else {
        if (amount >= 100) amount = 99;
        message.channel.bulkDelete(amount+1).catch(err=>{message.channel.send(`Cannot purge: ${err}`)});
      }
    }
    else {
      message.channel.send(`Cannot purge: You do not have enough permissions`);
    }
  }

  else {
    message.channel.send(`Invalid Command. Use ${pfx}help for commands`);
  }
});

client.on("messageDelete", message => {
  sql = `SELECT message_id FROM messages`;
  sqlcon.query(sql, function (err, results) {
    if (err) throw err;
    dbMsg = results.find(msg => msg.message_id === message.id);
    sql2 = `UPDATE messages SET is_deleted=1 WHERE message_id=${message.id}`;
    sqlcon.query(sql2, function (err, result) {if (err) throw err;});
  });
});

client.on("messageDelete", message => {
  sql = `SELECT message_id FROM messages`;
  sqlcon.query(sql, function (err, results) {
    if (err) throw err;
    dbMsg = results.find(msg => msg.message_id === message.id);
    sql2 = `UPDATE messages SET is_deleted=1 WHERE message_id=${message.id}`;
    sqlcon.query(sql2, function (err, result) {if (err) throw err;});
  });
});

client.on("messageDeleteBulk", messages => {
  msgIDs = [];
  messages.forEach(message => {msgIDs.push(message.id)});
  sql = `UPDATE messages SET is_deleted=1 WHERE `
  msgIDs.forEach(id => {
    sql += `message_id=${id} or `
  });
  sql = sql.slice(0,-3);
  sqlcon.query(sql, function (err, results) {
    if (err) throw err;
  });
});

client.on("messageUpdate", (oldMessage, newMessage) => {
  sqlcon.query(`SELECT content FROM messages WHERE message_id=${oldMessage.id}`, function (err, results) {
    if (err) throw err;
    if (results[0] !== undefined) {
      content = eval(results[0].content);
      content.push(newMessage.content);
      sqlcon.query(`UPDATE messages SET content='${arrayToString(content)}' WHERE message_id=${oldMessage.id}`, function (err, results) {if (err) throw err;});
    }
  });
});

var reddit_submission_ids = [];
async function getTopPost(message) {
  let subreddit = await reddit.getSubreddit('memes');
  let topPosts = await subreddit.getTop({limit: 50});
  let postToUse;
  for (submission in topPosts) {
    if (!reddit_submission_ids.includes(topPosts[submission].id)) {
      postToUse = topPosts[submission];
      reddit_submission_ids.push(postToUse.id);
      break;
    }
  }
  message.channel.send(`<https://reddit.com${postToUse.permalink}>\n${postToUse.url}`);
}

function addusertocounters(member) {
  let sql = `INSERT IGNORE INTO counters (user_id) VALUES ('${member.id}')`
  sqlcon.query(sql, function (err, result) {
    if (err) throw err;
    return 0;
  });
}

async function addMessage(message) {
  let content = [`${message.content}`];
  let channel_name = message.channel.name.replace(/\\/g, "\\\\").replace(/\'/g, "\\'");
  let content_string = arrayToString(content);
  sql = `INSERT INTO messages (message_id, author_id, content, is_deleted, channel_name) VALUES ('${message.id}','${message.author.id}','${content_string}',0,'${channel_name}')`
  sqlcon.query(sql, function (err, result) {
    if (err) throw err;
  });
}

function arrayToString(array) {
  let toReturn = `[`;
  for (item in array) {toReturn += `\\'${array[item].replace(/\\/g, "\\\\").replace(/\'/g, "\\'")}\\',`;}
  toReturn = toReturn.slice(0,-1);
  toReturn += `]`;
  return toReturn;
}

// Message is optional
function updateMember(member, message) {
  sql = `SELECT * FROM users WHERE user_id = '${member.id}';`;
  sqlcon.query(sql, function (err, result) {
    if (err) throw err;

    // If true, either the result is undefined, or the user has not taken the test, so no data exists in DB
    if (!result === undefined || !result.length == 0) {

      verified = Number(result[0].is_verified);
      failedTest = Number(result[0].has_failedTest);
      og = Number(result[0].is_og);
      gay = Number(result[0].is_gay);
      school = result[0].school;
      name = result[0].name;

      if (verified) {
        member.addRole(member.guild.roles.find(role => role.name === "Verified Student")).catch(err=>{outputChannel.send(`Couldn't add Verified Student role to ${member.user.tag} because of: ${err}`)});
        if (gay) member.addRole(member.guild.roles.find(role => role.name === "Gay")).catch(err=>{outputChannel.send(`Couldn't add Gay role to ${member.user.tag} because of: ${err}`)});
        if (og) member.addRole(member.guild.roles.find(role => role.name === "OG")).catch(err=>{outputChannel.send(`Couldn't add OG role to ${member.user.tag} because of: ${err}`)});
      }
      else if (failedTest && message != undefined) {
        reason = result[0].reason_failed;
        client.users.get(member.id).send(`Sorry, but you failed the verification test. For further support contact the \`STAFF\` role.`);
        outputChannel(`<@&${staffRole.id}> Do not verify ${member.user.tag} because of the following reason: ${reason}`);
      }
      // For people that have already joined and not have taken the verification test
      else if (!verified && message != undefined) {
        message.channel.send(`You have not taken the verification test or there has been an error in the bot. Contact the \`STAFF\` role for further support.`);
      }

      switch(school) {
        case 'pcms':
          member.addRole(member.guild.roles.find(role => role.name === "Pacific Cascade MS")).catch(err=>{outputChannel.send(`Couldn't add \`Pacific Cascade MS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'ims':
          member.addRole(member.guild.roles.find(role => role.name === "Issaquah MS")).catch(err=>{outputChannel.send(`Couldn't add \`Issaquah MS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'plms':
          member.addRole(member.guild.roles.find(role => role.name === "Pine Lake MS")).catch(err=>{outputChannel.send(`Couldn't add \`Pine Lake MS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'maywood':
          member.addRole(member.guild.roles.find(role => role.name === "Maywood MS")).catch(err=>{outputChannel.send(`Couldn't add \`Maywood MS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'beaver_lake':
          member.addRole(member.guild.roles.find(role => role.name === "Beaver Lake MS")).catch(err=>{outputChannel.send(`Couldn't add \`Beaver Lake MS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'ihs':
          member.addRole(member.guild.roles.find(role => role.name === "Issaquah HS")).catch(err=>{outputChannel.send(`Couldn't add \`Issaquah HS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'skyline':
          member.addRole(member.guild.roles.find(role => role.name === "Skyline HS")).catch(err=>{outputChannel.send(`Couldn't add \`Skyline HS\` role to ${member.user.tag} because of: ${err}`)});
          break;
        case 'other_hs':
          member.addRole(member.guild.roles.find(role => role.name === "Other HS")).catch(err=>{outputChannel.send(`Couldn't add \`Other HS\` role to ${member.user.tag} because of: ${err}`)});
          break;
      }
    }

    else {
      if (message != undefined) {
        message.channel.send(`Sorry, you have not taken the verification test or there has been an error in the bot. Contact the \`STAFF\` role for further support.`)
      }
    }
  });
}

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

// To get file length of this file for current `activity`
function countFileLines(filePath){
  return new Promise((resolve, reject) => {
  let lineCount = 0;
  fs.createReadStream(filePath)
    .on("data", (buffer) => {
      let idx = -1;
      lineCount--; // Because the loop will run once for idx=-1
      do {
        idx = buffer.indexOf(10, idx+1);
        lineCount++;
      } while (idx !== -1);
    }).on("end", () => {
      resolve(lineCount);
    }).on("error", reject);
  });
};

function print(obj) {console.log(obj)};

client.login(config.token);
