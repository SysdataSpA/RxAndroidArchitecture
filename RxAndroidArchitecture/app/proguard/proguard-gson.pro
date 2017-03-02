## This is a configuration file for ProGuard.
# Gson rules
-keepattributes Signature
-keepattributes Annotation
-keep class sun.misc.Unsafe { *; }
-keep class com.google.** { *; }
-keep class sun.misc.** { *; }