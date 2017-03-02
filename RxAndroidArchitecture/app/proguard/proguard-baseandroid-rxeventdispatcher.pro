## This is a configuration file for ProGuard.
# Otto rules
-keepclassmembers class ** {
    @com.baseandroid.events.rx.annotations.RxSubscribe public *;
    @com.baseandroid.events.rx.annotations.RxProduce public *;
}