# Grizzlynator Base

## Start by Cloning the Repository - Clone one time to start working with the repository
* `git clone https://github.com/team295/GrizzlynatorBase.git`
* Since you likely cloned the repository to make changes, create a working branch (See next step)
* Please do not work (i.e. modify files) on the master branch

## Everytime you start on a new functionality - Create a new branch
### 1. Retrieve all changes from github so you have the latest set of files 
* `git checkout master`
* `git pull origin master --rebase`

### 2. Create a branch  branch (your branch name)`
* `git branch (your branch name)`
* `git checkout (your branch name)`
* Example: `git branch tak-climber  then  git checkout tak-climber`

### 3. Save your new branch to github.com
* `git push`
* During the very first push, you will likely get instruction to set the upstream location
* `git push --set-upstream origin (your branch name)`


## Normal Daily Workflow
### Make your changes to your branch
* Make sure that your are NOT on the master branch
* `git checkout (your branch name)`
* Edit files
* `git add .`
* `git commit`      (In the editor: `i` = Insert.  Add your comment, then hit the `esc` key,  `:wq` to  Write and Quit) 
* ...

## Save your changes to github.com
### Before pushing your changes, sync up with GitHub and resolve any conflicts
(Also, do this anytime you need to get the latest code from Github)
* Retrieve all changes from github [master branch at origin] to [master] 
* `git checkout master`
* `git pull origin master --rebase`
* Then merge any updates into your branch
* `git checkout (your branch name)`
* `git merge master`

### Push the changes to GitHub
* `git push`
