import re
import time
import json
import wget
import math
import sys
import praw
import os
from collections import OrderedDict
import threading
from queue import Queue

client_id = ''
client_secret = ''
username = ''
password = ''


def main():
    rd = RedditURLDownloader(client_id, client_secret, username, password)

    if len(sys.argv) <= 1:
        sys.exit("Usage: python upton.py <file>")

    reddit = rd.getReddit()

    file_name = sys.argv[1]
    links = rd.readLinks(file_name, reddit)

    # Eliminate duplicates
    links = list(OrderedDict.fromkeys(links))

    rd.tDownload(links)


class RedditURLDownloader:
    def __init__(self, client_id, client_secret, username, password):
        self.client_id = client_id
        self.client_secret = client_secret
        self.username = username
        self.password = password

    def getReddit(self):
        return praw.Reddit(client_id=self.client_id, client_secret=self.client_secret, username=self.username, password=self.password, user_agent="rud/1.0 by DiamondMiner88")

    def readLinks(self, file_name, reddit):
        current_dir = os.path.dirname(os.path.abspath(__file__))
        links = open(os.path.join(current_dir, file_name),
                     "r").read().split('\n')
        return links

    def worker(self):
        while not self.q.empty():
            item = self.q.get()
            try:
                wget.download(item)
            except IOError as e:
                print("Something went wrong ", e)
            self.q.task_done()

    def tDownload(self, links):
        self.q = Queue()

        for item in links:
            if not item == '':
                self.q.put(item)

        for i in range(8):
            t = threading.Thread(target=self.worker)
            t.daemon = False
            t.start()

        self.q.join()


if __name__ == '__main__':
    main()
