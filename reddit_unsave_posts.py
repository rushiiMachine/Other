import praw

credentials = {
    "client_id": "",
    "client_secret": "",
    "username": "",
    "password": "",
}

unsave_comments = False
subreddits_to_unsave_posts_from = ['memes', 'dankmemes', 'animemes', 'askreddit', 'wtf', 'unpopularopinion', 'confessions', 'nextfuckinglevel', 'pewdiepiesubmissions', 'funny', 'interestingasfuck', 'blackmagicfuckery',
                                   'waitwhat', 'hmmm', 'tihi', 'holup', 'gifsthatkeepongiving', 'osugame', 'yesyesyesno', 'nonono', 'nononoyes', 'iamatotalpieceofshit', 'youseeingthisshit', 'facepalm', 'oddlysatisfying', 'facepalm', 'assholedesign']
subreddits_not_to_unsave_from = []


def start():
    global credentials, unsave_comments

    reddit = praw.Reddit(client_id=credentials['client_id'], client_secret=credentials['client_secret'],
                         username=credentials['username'], password=credentials['password'], user_agent="unsave_posts")

    bad_subreddits = []
    for subreddit in subreddits_to_unsave_posts_from:
        bad_subreddits.append(reddit.subreddit(subreddit))

    good_subbredits = []
    for subreddit in subreddits_not_to_unsave_from:
        good_subbredits.append(reddit.subreddit(subreddit))

    # , params={'after': 'fd42x'}
    saved = reddit.user.me().saved(limit=None, params={'after': 'fmxtpa'})

    # total_posts = 0
    # for i in saved:
    #     total_posts += 1
    # print(total_posts)

    for s in saved:
        if not isinstance(s, praw.models.Comment) and s.subreddit in bad_subreddits:
            try:
                print('Unsaving:', s.id, s.title)
                s.unsave()
            except AttributeError as err:
                print(err)


if __name__ == "__main__":
    start()
