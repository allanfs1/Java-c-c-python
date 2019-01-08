#-*-coding:utf8;-*-
#qpy:3
#qpy:console

#qpy:3
#qpy:consolef
import time,os
import curses
Max = 20
i=0

"""Arvore de Natal 24/12/2018"""
print("\n Arvore de Natal: 24/12/2018\n")

def arvore():
 for i in range(Max):
  if i == 0:
    print(Max*" " + "*")
    
  elif i == Max-1:
    divi=(2*i+1)/2
    print(int(divi)*" " +"||")
    
  else:
    print(" "*(Max-i) + "*" *(2*i+1))
    

def  pisca():
 for i in range(Max):
  if i == 0:
    print(Max*" " + "@")
    
  elif i == Max-1:
    divi=(2*i+1)/2
    print(int(divi)*" " +"||")
    
  else:
    print(" "*(Max-i) + "@" *(2*i+1))

i=0
stdscr= curses.initscr()

while True:
  time.sleep(2)
  if i % 2 == 0:
   pisca()
    
  else:
   arvore()
   
   
  try:
   stdscr.addstr(tmp)
   stdscr.refresh()
   pass

  except:
   pass

print("\n Feliz Natal")