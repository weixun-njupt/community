##社区
git add .
git commit --amend --no-edit
git commit -m ""
git push
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate