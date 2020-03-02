# User Guide

## Features 
1. Managing tasks 
   Your tasks can be added and deleted using **todo**, **deadline** and **event** Commands.
2. Marking your tasks as completed
   Track the completion status of your tasks by typing `done` followed by the task number in the command line.
3. Display all your tasks 
   To view the tasks you have so far, type `list` in the command line.
4. Saving your data
   Your tasks and information are stored automatically when you add a task into the program. Upon closing and reopening of Duke, your data is retained. 

### Adding Tasks
There are 3 ways you can add tasks to your task list, namely - todo, deadline or event. More details can be found below.

## Usage

### `todo` - Creates a Todo task

This commands adds a todo task to your current list.
It appears as a `[T]` beside the description to represent a todo task.

Format:
`todo <description>`

*`<description>` is the description of the todo

Example of usage: 

`todo <code for CS2113T>`

Expected outcome:

```
____________________________________________________________ 
Got it. I've added this task:
  [T][✘] study for CS2113T
Now you have 1 task in the list
____________________________________________________________
```
### `deadline` - Creates a Deadline task

This command is created with a description with a deadline date and time. 
It appears as a `[D]` beside the description to represent a deadline task.

Format: 
`deadline <description><space></by><date><space><time>`

*`<description>` is the description of the task with a deadline
*`<space>` represents a white space
*`</by>` is a **required** parameter
*`<date>` must follow the dd/mm/yyyy format
*`<time>` must follow the hhmm format

Example of usage: 

`deadline <study /by 22/05/2020 1530>`

Expected outcome:

```
____________________________________________________________
Got it. I've added this task:
 [D][✘] study (by:Fri 22 May 2020 03:30 pm)
Now you have 2 task in the list
____________________________________________________________
```
### `event` - Creates a Event task

Similar to deadline feature, an event task is created with both the description parameter and a deadline date and time.
It appears as a `[E]` beside the description to represent an event task.

Format: 
`event <event><space></at><date><space><time>`

*`<event>` is the description of the task
*`<space>` represents a white space
*`</at>` is a **required** parameter
*`<date>` must follow the dd/mm/yyyy format
*`<time>` must follow the hhmm format

Example of usage: 

`event <party /at 23/05/2020 0030>`

Expected outcome:

```
____________________________________________________________ 
Got it. I've added this task:
   [E][✘] party (at:Sat 23 May 2020 12:30 am)
Now you have 3 task in the list
____________________________________________________________
```
### `done` - Marks a task as completed

This command marks a task as Done, which displays as a `✓` beside the task.

Format: 
`done <task number>`

*`<task number> represents a index of the task in the current task list

Example of usage: 

`done <2>`

Expected outcome:

```
____________________________________________________________
Nice! I've marked this task as done:
  [E][✓] study (by:Fri 22 May 2020 03:30 pm)
____________________________________________________________
```
