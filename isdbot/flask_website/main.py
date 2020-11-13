# requires flask, mysql packages to be installed
from flask import Flask, render_template, url_for
from os.path import join, abspath, dirname
import json, mysql.connector, atexit

app = Flask(__name__)
wd = abspath(dirname(__file__))
with open(join(wd,'../config.json')) as f:
    config = json.load(f)
sqlcon = mysql.connector.connect(
  host=config['host'],
  user=config['user'],
  password=config['password'],
  database=config['database']
)

@app.route("/")
def home():
    link = '/channels/general'
    return render_template('redirect.html', link=link)

@app.route("/channels")
@app.route("/channels/general")
def general():
    sqlcursor = sqlcon.cursor()
    query = "SELECT message_id,author_id,content,is_deleted,channel_name FROM messages WHERE channel_name='general' ORDER BY message_id DESC LIMIT 50"
    sqlcursor.execute(query)
    results = sqlcursor.fetchall()
    content = []
    for message_id,author_id,content_broken,is_deleted,channel_name in results:
        toAdd = {"message_id": message_id, "content": json.load(content_broken)}
        content.append(toAdd)
    
    return render_template('channel.html', results=results, resultslength=len(results), channel_name='general', content=content)

def exit_handler():
    print('Exiting... - via exit_handler')
atexit.register(exit_handler)

if __name__ == '__main__':
    app.run(debug=True,host= '0.0.0.0',port=31245, use_reloader=False)