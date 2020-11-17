looprunning = False

F8::
  looprunning := !looprunning
  Loop {
    If (!%looprunning%) Break
    Send cat
    Sleep 30
    Send {Enter}
    Sleep 60000
  }
