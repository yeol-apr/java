#!/bin/bash

# Step 1: 确认当前分支名称（假设是 main）
CURRENT_BRANCH=$(git symbolic-ref --short HEAD)

# Step 2: 列出需要删除的大文件路径（注意：这里不包含 .git/objects 下的文件，因为它们是 Git 内部对象）
FILES_TO_REMOVE=(
  "shangguigu_javaweb/资料/software/jdk17/jdk-17_windows-x64_bin.zip"
  "shangguigu_javaweb/资料/software/postman/Postman-win64-9.15.2-Setup.exe"
  "shangguigu_javaweb/资料/software/vscode/VSCodeUserSetup-x64-1.74.0.exe"
  "shangguigu_javaweb/资料.zip"
  "Spark/spark/scala-2.11.8.msi"
  "Spark/spark/spark-2.1.1-bin-hadoop2.7.tgz"
  "代码/阶段项目-微头条项目/前端代码/my-vue3-vite-project.zip"
)

# Step 3: 构建 rm 命令
RM_COMMAND=""
for file in "${FILES_TO_REMOVE[@]}"; do
  RM_COMMAND+="rm -f \"$file\" && "
done
RM_COMMAND=${RM_COMMAND%&& } # 移除最后一个 '&& '

# Step 4: 使用 git filter-branch 删除这些文件的所有历史记录
echo "正在从 Git 历史中删除大文件..."
git filter-branch --force --index-filter "$RM_COMMAND" --prune-empty --tag-name-filter cat -- --all

# Step 5: 清理 Git 缓存并回收空间
echo "清理 Git 缓存..."
git reflog expire --expire=now --all
git gc --prune=now
git gc --aggressive --prune=now

# Step 6: 强制推送到远程仓库（慎用）
echo "清理完成。是否要强制推送回远程仓库？[y/N]"
read answer
if [[ "$answer" == "y" || "$answer" == "Y" ]]; then
  echo "正在强制推送..."
  git push origin --force --all
  git push origin --force --tags
else
  echo "跳过推送，请手动执行 'git push --force' 如果需要同步远程仓库。"
fi

echo "✅ 清理完成！"
