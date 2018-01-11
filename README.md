# Grizzlynator 2017

## Cloning the Repository - Clone one time to start working on the 2017 Robot Code
* `git clone https://github.com/team295/2017Robot.git`
* Since you likely cloned the repository to make changes, create a working branch (See next step)
* Please do not work (i.e. modify files) on the master branch

## Creating a new branch workflow - Everytime you start on a new functionality 
### 1. Retrieve all changes from github so you have the latest set of files 
* `git checkout master`

### 2. Create a branch  branch (your branch name)`
* `git checkout -b (your branch name)` (use -b to create new branch)
* Example: `git checkout -b tak-climber`

## 3. Normal Daily Workflow
### Make your changes to your branch
* Make sure that your are NOT on the master branch
* `git checkout (your branch name)`
* Edit files
* `git add *`
* `git add -u  `        (use this if you want to remove deleted files from repo)
* `git commit -m "Commit Description - What are you commiting"`      (In the editor: `i` = Insert.  Add your comment, then `:wq` to  Write and Quit) 

### 4. Save your new branch to github.com
* `git push`
* During the very first push, you will likely get instruction to set the upstream location
* `git push --set-upstream origin (your branch name)`

## 5. Rebasing your Branch to Master
* `git checkout master`
* `git pull origin master`
* `git checkout (your branch name)`
* `git rebase master`
  *  At this point you may need to handle Merge Conflicts
  *  `git status` will show you each file that has merge conflict
  *  Open each file with merge conflict and search for the merge conflicts and resolve them
  *  `git add`
  *  `git rebase --continue`
  *  Repeat for each commit on branch until rebase completes
* At this point you have two options: merge to master or continue working on branch
* If you want to contnue working on branch perform
* `git push -f`

## Merge your changes to master on github.com
###Before merrging your changes always run the rebase steps!!!! Before
(Also, do this anytime you need to get the latest code from Github)
* Retrieve all changes from github (to origin/master) 
* `git checkout master`
* `git merge (your branch)`

### Push the changes to GitHub
* `git push`
