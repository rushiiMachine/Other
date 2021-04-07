import praw

credentials = {
    "client_id": "",
    "client_secret": "",
    "username": "",
    "password": "",
}

reddit = praw.Reddit(client_id=credentials['client_id'], client_secret=credentials['client_secret'],
                     username=credentials['username'], password=credentials['password'], user_agent="unsave_posts")

saved = reddit.user.me().saved(limit=None)

for s in saved:
    if s.subreddit == reddit.subreddit('animegirls') and not isinstance(s, praw.models.Comment):
        # s.unsave()
        print(s.url)
