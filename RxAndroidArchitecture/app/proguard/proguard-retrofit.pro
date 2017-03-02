## This is a configuration file for ProGuard.
# Retrofit rules
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes *Annotation*,Signature
-dontwarn okio.*