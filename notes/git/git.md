
### 环境配置

#### git简介

什么是git 

> git 是一种分布式版本控制系统，简单说就是控制不同阶段的project，方便回溯与代码协同工作

#### 配置全局变量

```bash
git config --global user.name weinijuan
git config --global user.email qiyue20h@qq.com
git config --global init.defaultBranch main # 将分支默认名称改为main
```

#### 查看配置

```bash
git config -l # -l 表示列举，列表的意思
git config --global -l # 列出用户自定义的全局变量
git config --system -l # 列出系统给用户定义的变量
git config user.name # 查看用户名
```

#### 配置文件

>  系统配置文件git安装目录下的gitconfig文件中
>  用户配置文件在C盘用户目录下的gitconfig文件中

==可以通过直接修改配置文件的方式达到改变git的作用，也可以配置错了以后直接更改配置文件==





### 仓库创建

#### 本地仓库创建

新建一个空白文件夹（不空白也可以，空白最方便），在文件夹内右键打开git  bash

``` bash
git init
```

就能初始化一个空的repository。 

对于不空白文件夹，依次使用下列命令,将文件记录在git仓库中
```shell
git add .
git commit "repository init"
```


#### 克隆仓库创建

在github或者gitee上新建一个仓库或者找现有的仓库并将其fork到自己的仓库中，复制自己的ssh或者https等url，在本地自己的空白文件夹或者repositiory右键打开git bash

```bash
git clone git@gitee.com:weinijuan/git-learning.git
# 上面是ssh url，速度更快更方便
git clone https://gitee.com/weinijuan/git-learning.git
# 这是http url，不需要记忆，仓库会给你的
```

==通过clone现有的仓库便能自动完成与仓库的连接==

为什么必须与自己的仓库进行连接？不能与其他的仓库连接？

> 只有与自己远程仓库连接，才能将自己本机仓库push到自己远程仓库中（push到别人仓库没有权限，看后面的密钥连接），通过自己的远程仓库再与其他远程仓库进行操作。与别人仓库连接有权限pull但不能push


#### 密钥连接

> 密钥连接的目的是让远程仓库与本机可以直接连接，以后push 的时候而无需进行重复的输入账号密码。

###### **生成密钥**

```bash
ssh-keygen -t rsa -C 你的邮箱xxx@xx.com
```

###### 查看密钥

通常密钥位于C盘user目录下的.ssh文件夹中,有一对密钥，将公钥（.pub后缀）复制，粘贴到github,gitee等网站上的个人密钥配置即可完成密钥连接。

Linux中在主目录的.ssh文件夹中，通过 `ls -a | grep ssh`来进行搜索.ssh目录

#### 远程仓库创建

github 或者gitee服务器上的我们称之为remote repositiory ,远程仓库。通过上面的操作我们在本机上也建立了一个仓库，然而如果要将本地仓库与远程仓库连接起来，除了clone的方式，还有另一种通用的方式可以直接添加远程仓库

```bash
git remote add origin git@gitee.com:weinijuan/git-learning.git
git remote add newName git@github.com:weinijuan/studyGit.git
```

**说明：**
-  git remote add 表示增加一个远程仓库，origin 和 newName是对应远程仓库的名字，最后面是远程仓库的链接地址
-  最后面是ssh url，也可以用 http的
- origin是一个默认名字，通常用来表示初始的remote repository
- 如果origin已经被使用，则需要换一个新名字

> 现在我的本机仓库同时连上了两个远程仓库，第二个远程仓库的名字就叫newName

### 仓库管理

##### 工作区，寄存区，版本库

> 工作区：本机磁盘上的文件夹就是你的工作区，你对这个文件夹所做的任何修改都是在工作区完成的

> 寄存区： 通过add 能把工作区的多个修改放到寄存区，最后一次commit全部提交到版本库

> 版本库：每次提交(commit)就是一个版本,所有版本就是一个版本库

##### 增删文件

###### 增加文件

``` bash
git add filename.md # 将文件添加到寄存区
git add . # 添加所有文件
vim filename.md # 修改文件，寄存区的文件还是原文件，而工作区文件已经发生了改变
git diff filename.md # 查看寄存区与工作区文件的差异
git status  # 查看所有文件的状态
git add filename.md # 再次将修改放到寄存区，每次修改后都应该放到寄存区，否则后面commit是不对新修改起作用的
git commit -m "add filename.md" # 每次提交的时候都应该对提交的内容加以注释，因而 -m 是必要的
# commit 只对寄存区中的文件提交到版本库中，因而修改未寄存的文件不会被提交
git status # 重新查看所有文件的状态
```

**注意：**
- 直接查看磁盘上的文件是看到的是工作区，无法看到寄存区


###### 删除文件

```bash
rm filename.md # 工作区删除文件
git rm filename.md # 寄存区删除文件
git commit -m "remove filename" #提交到版本库
```


###### 状态信息

- untracked file : 未跟踪文件，新文件，一次也没有add 过  -> 需要 add 
- changes not staged for commit : 修改了但是没有add的文件，其中modified 表示已修改 -> 需要add 
- changes to be commit : 寄存了但是未提交的文件 -> 需要commit 
- nothing to be commit , working tree clean : 所有文件已提交，没有新的修改 -> 需要继续写代码了

##### 版本库与版本号

> 每个版本库都保留了一份工作目录的状态，相当于时间点，以后到哪个版本库就相当于到哪个时间点。而版本号是版本库的唯一id，通过版本号可以找到对应的版本库

###### 查看版本号 

```bash
git log # 查看提交版本信息
git reflog # 查看恢复日志，在使用版本恢复后使用
```

![image-20220826110813060](../image/image49.png)

commit 后面的长长的字符是版本号，HEAD->master 说明是在master分支上进行的，HEAD指向的是始终最新的版本。作者是全局变量，最后一行是我们提交时写的注释。

**其他相关：**
- git log --pretty=oneline # 日志按照一行输出，更精简
- git config --global alias.logs 'log --pretty=oneline' #设置别名，看后文

###### 版本回溯

```bash
git reset --hard HEAD # 回到当前版本，在--hard的情况下会舍弃所有未提交的修改,等价于git reset --hard HEAD~
git reset --hard HEAD^ # 回到上一个版本，貌似在zsh上只能用~的方式，等价于~1
git reset --hard HEAD^^ # 回到上两个版本
git reset --hard HEAD~100 # 回到上100个版本
git reset --hard c7862 # 回到以c7862开头的版本号对应的版本
```

**用法：**
- --hard表示工作目录，寄存区，版本区都回到指定的版本的时候。还有其他要用再搜
- --mixed表示寄存区（默认情况），版本区都回到指定的版本，工作区不变

**注意：**
- 在Linux的zsh终端上，貌似只能使用git reset --hard HEAD~n 的方式，而不能用^的方式

```bash
git reflog # 回到之前的版本（时间点），原本后面的版本用log 就看不见了，需要用reflog才能看见
```

##### 版本回溯

###### 工作区的回溯

```bash
git checkout -- filename # checkout 中--是必须的
```

撤销工作区的修改，换言之，工作区回到最近一次commit或者add的时候.

**其他相关：**
- git config --global alias.unchange 'checkout --' # 设置unchange作为别名，un 表示撤销，撤销工作区的改变，有点像ctrl+z，只不过是回到上一次commit 或add
- git config --global alias.unwork 'checkout --' # 再设置一个别名，un 表示撤销，work表示工作区

###### 寄存区的回溯

```bash
git reset HEAD filename.md # filename.md回到当前commit版本，在--soft的情况下会舍弃寄存区中所有未提交的修改，工作区不变
# 因而等价于寄存区回溯
git reset --mixed HEAD  # 和上面等效
```

**使用说明：**
- git reset 默认是--soft的情况
- --soft:寄存区回溯，工作区不变。--hard：寄存区和工作区都回溯。

**其他相关：**
- git config --global alias.unstage 'reset HEAD' # 设置了unstage作为reset HEAD的别名，意为撤销stage


###### 版本库的回溯

```bash
git reset --hard HEAD # 回到当前版本，在--hard的情况下会舍弃所有未提交的修改,等价于git reset --hard HEAD~
git reset --hard HEAD^ # 回到上一个版本，貌似在zsh上只能用~的方式，等价于~1
git reset --hard HEAD^^ # 回到上两个版本
git reset --hard HEAD~100 # 回到上100个版本
git reset --hard c7862 # 回到以c7862开头的版本号对应的版本
```

**用法：**
- --hard表示工作目录，寄存区，版本区都回到指定的版本的时候。还有其他要用再搜
- --mixed表示寄存区（默认情况），版本区都回到指定的版本，工作区不变

**注意：**
- 在Linux的zsh终端上，貌似只能使用git reset --hard HEAD~n 的方式，而不能用^的方式

```bash
git reflog # 回到之前的版本（时间点），原本后面的版本用log 就看不见了，需要用reflog才能看见
```

#### 提交记录
```
git log # 查看提交信息
git blame FILENAME # 以列表形式查看文件的修改情况
```

##### 提交记录
```shell
git log [选项] [分支名/提交的哈希值]
```

**选项：**
- `-p`：显示提交的补丁（具体更改内容）。
- `--oneline`：以简洁的一行格式显示提交信息。
- `--graph`：以图形化方式显示分支和合并历史。
- `--decorate`：显示分支和标签指向的提交。
- `--author=<作者>`：只显示特定作者的提交。
- `--since=<时间>`：只显示指定时间之后的提交。
- `--until=<时间>`：只显示指定时间之前的提交。
- `--grep=<模式>`：只显示包含指定模式的提交消息。
- `--no-merges`：不显示合并提交。
- `--stat`：显示简略统计信息，包括修改的文件和行数。
- `--abbrev-commit`：使用短提交哈希值。

例如：`git log --graph --pretty=oneline --abbrev-commit`查看日志以图形方式。 `git log --pretty=oneline --abbrev-commit`以简洁的形式查看提交日志

##### 文件修改
略

### 分支管理

##### 创建分支

```bash
git branch # 查看分支
git branch dev # 新建分支dev ，development开发分支缩写。
git checkout dev # 切换到分支dev
# 切换分区前必须要全部commit
git checkout -b feature #新建分支feature并且切换到这个分支上去
```

**特别注意**
- 切换分支前必须保证当前所有内容已经commit，否则工作区的内容就会丢失。当然在这种情况下可以使用`git stash`来隐藏现场。通过`git stash list`查看隐藏现场列表，`git stash apply STASH_NAME`来进行恢复，通过`git stash drop STASH_NAME`来进行删除，通过`git stash pop STASH_NAME`又恢复又删除。

##### 分支操作

```bash
git branch -d dev # 删除分支dev
git branch -M newName # 将当前分支名称更改为newName
git branch -set-upstream-to=origin/main main # 将origin/main设置为本地main的上游分支，后续push和pull时将会使用
git branch checkout dev # 将当前分支切换为dev分支
git push origin --delete 远程分支名 # 删除远程仓库的远程分支
```

##### 分支合并

```bash
git merge dev # 合并分支dev 到当前分支
```

###### 无冲突：Fast forward
![](attachments/Pasted%20image%2020230919202620.png)
在这种情况下HEAD指向的主分支会自动更改指针，从而指向dev分支所在的状态，整个合并过程就跟没有发生一样。

###### 有冲突: 手动解决
![](attachments/Pasted%20image%2020230919202858.png)
在master和feature1两个分支做了不同的修改时，这时候使用`git merge feature1`就会出现fatal（致命问题）,此时出现问题的文件需要我们手动修改解决。

###### 变基：rebase

```shell
git rebase 
```

使git 还没有push的提交历史变成一条直线，用于整理提交记录

**其他相关**
- 通过`git log --graph --pretty=oneline --abbrev-commit`可以通过可视化的方式查看提交记录

### 远程仓库

#### 查看远程仓库
```shell
git remote # 查看远程仓库
git remote -v # 附带信息
```

#### 添加远程仓库
```shell
git remote add origin "git@...."
git remote add dev "git@..."
```
- git remote add 表示添加远程仓库
- origin和dev表示远程仓库在本机上的名字
- 在本地添加远程仓库时，需要真的在远程存在这样一个仓库

#### 删除远程仓库
```shell
git remote remove origin
```
- git remote remove表示删除远程仓库，不会真的删除远程的仓库，只是解除本机上与远程仓库的绑定而已

**其他相关：**
- 记不到命令名字可以使用git remote -h来查看，或者使用git remote --help 来查看帮助信息，其他命令也是一样的
- `git push origin --delete 分支名` 可以删除远程仓库的远程分支

#### 推送远程仓库
**命令格式**
```shell
git push [选项] 远程仓库名 本地分支名：远程分支名
```
**实例**
```shell
git push -u origin main 
git push origin main
git push origin main:dev
git push 
```

**理解四种push**
1. 对于一个本地仓库和一个远程仓库（origin），第一次使用`git push`将会报错。因为没有指定push到哪个仓库,git并不会自然的认为你会push 到origin远程仓库去。
2. 如果使用`git push origin main`不会报错，但是origin是一个仓库名称，而main是一个本地分支名称，其实这条命令的完整形式是`git push 远程仓库名 本地分支名：远程分支名` 在远程分支名和本地分支名相同的时候，就可以省略远程分支名。因此这条命令相当于`git push origin main:main`,是将本地main分支push到origin仓库的main 分支。当使用`git push origin test`的时候，要将本地仓库的test分支push到远程仓库（origin）的test分支，当origin没有test分支的时候，就会自动在origin仓库创建一个test分支。
3. `git push origin main:dev`是将本地仓库的main分支push到远程仓库(origin)的dev分支
4. 为了避免每次都使用`git push origin main` ,可以使用`git push -u origin main`, u意为"upstream"上游分支，使用这条命令就可以将origin/main分支和本地main分支关联起来(设置上游分支)，从而下次直接使用`git push`就相当于使用`git push  origin main`，同样也可以直接使用`git pull`相当于`git pull origin main`.
5. 上游分支名称应当和本地分支名称相同。

**其他相关**
- 也可以使用`git branch -set-upstream-to=origin/main main`来将本地main分支和远程main分支关联起来,从而使用`git push`命令；也可以在创建分支时使用`git checkout -b main origin/main`同样实现上述功能。
- `git push -u origin main:dev` 的指令意义不大，对于远程分支名称和本地分支名称不相同的时候，使用-u参数并没有多大的意义。也就是说上游分支尽量和本地分支名称相同。
- 如果在push的时候出现冲突，请参看后面部分

> 无论是push 还是pull,无论是推送还是拉取，本质其实都是获取一个分支，再与另外一个分支进行合并(merge),因此不能使用默认的合并方式的时候就会报错从而手动解决


#### 拉取远程仓库
**命令格式**
```shell
git pull 远程仓库名 远程分支名：本地分支名
```

**实例**
```shell 
git pull origin main
git pull origin dev:main
git pull
```
- `git pull origin main`将远程origin仓库的main分支拉取到本地的main分支
- `git pull origin dev:main`将远程的dev分支拉取到本地的main分支
- `git pull`在没设置上游分支时会报错，如果设置了上游分支(假设为origin的main分支)，那么等同于`git pull origin main`。上游分支可以通过`git push -u xxx`或者`git branch -set-upstream-to=origin/main main`的方式设置上游分支。
- 如果本地没有对应的分支，那么默认就会创建一个。比如`git pull origin dev:main`如果本地没有main分支，那么默认就会在本地创建一个main分支。

**注意**
- `git pull ` 和`git push`的远程分支名与本地分支名的位置是相反的，不要混淆了。可以通过哪个更重要就放在更前面来记忆，push的时候本地分支更新更重要，pull的时候远程分支更新更重要

#### 仓库合并冲突

1. 远程有修改，本地没修改，可以pull,不可以push. 需要先将远程的pull下来，然后才能push.
1. 如果远程的有了修改，本地的也有修改，需要先将远程的pull下来并进行合并，这时候会有冲突，需要解决冲突，然后才能push
2. 远程和本地的提交历史记录不是来自于同一个祖先，通常见于两个不同的仓库想要push与pull, 可以使用`git pull --no-rebase --allow-unrelated-histories`进行合并。这个--no-rebase也可以替换为--rebase等。


### 标签管理

> 由于commit的哈希值并不好记忆，于是就引入了标签机制，其实就相当于commit的哈希值的一个别名，类似于域名与IP地址的关系，通过给某个特定的commit打上标签，就能方便的找到这次提交


#### 创建标签

```shell
git tag # 查看标签列表
git tag v1.0 # 给当前分支的最新提交打上v1.0的标签
git tag v1.1 f29fa3 # 给哈希值前几位为f29fa3的提交打上v1.1的标签
git show v1.0 # 查看v1.0对应的提交的信息
git tag -a v1.0 -m "this is version 1.0" f29fa3 # 给哈希值前几位为f29fa3的提交打上v1.0的标签,同时附上标签信息
```

#### 操作标签
```shell
git tag -d v1.0 # 删除本地标签
git push origin v1.0 # 将v1.0标签push到远程仓库，由于标签是与分支无关的（与提交有关），所以无需分支名称。
git push origin --tags # push所有标签到远程仓库
git push origin :refs/tags/<tagname> # 删除一个远程标签（需要先删除本地标签）
```


### 未完待续

> 目前够用了，用到再学 
>
> 另外附上一个链接 [Git教程 - 廖雪峰的官方网站 (liaoxuefeng.com)](https://www.liaoxuefeng.com/wiki/896043488029600)，好使