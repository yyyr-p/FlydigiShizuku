# FlyDigiShizuku
让吃灰的飞智小游激活器为免 Root 玩机出点力。
# 兼容性
- *可能*与原版飞智游戏厅不兼容。
- 仅 2020 年 2 月批次的飞智小游激活器经过测试。
- 若批次更旧，请参阅原项目。
- 若批次更新，~~请提供相关信息并扔issue~~ 我懒爆了，只是为了自己用。接受pr。
# 使用方法
## 普通的
- 从官方渠道下载 [Shizuku](https://github.com/RikkaApps/Shizuku) 并安装。
- 从 [Releases](https://github.com/yyyr-p/FlydigiShizuku/releases) 下载并安装 apk，然后至少启动一次。
- 随后就可以把软件图标藏起来吃灰了。如有需要可以自己动手改无图标版本，此处不改是为了有需要时启动方便。
- 此时连接飞智小游激活器，并允许 USB 调试。
- 若操作无误，你应当看到 Shizuku 主页面自动显示并已开始运行。
## 进阶的
如有需要，可以自己使用 apk 编辑器编辑 apk 内名为 `activate.sh` 的 shell 脚本。该脚本将在飞智小游连接时以 adb shell 权限自动运行。其余同上。
# 编译
~~自己想办法。~~ 请确保已正确安装 JDK 8。
```shell
gradlew build
```
