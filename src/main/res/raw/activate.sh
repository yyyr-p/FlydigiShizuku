#!/system/bin/sh

path=/sdcard/Android/data/moe.shizuku.privileged.api/start.sh
comp=moe.shizuku.privileged.api/moe.shizuku.manager.MainActivity

if [ ! -r $path ]; then
    am start -n $comp
    sleep 3
fi

/system/bin/sh $path

if [ $? -eq 0 ]; then
    am start -n $comp
fi