# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Lxh\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
 #指定代码的压缩级别
-optimizationpasses 5
 #包名不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#优化/不优化输入的类文件
-dontoptimize
#预校验
-dontpreverify
#混淆时是否记录日志
-verbose
#混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#把混淆类中的方法名也混淆了
-useuniqueclassmembernames
#优化时允许访问并修改有修饰符的类和类的成员
-allowaccessmodification
#将文件来源重命名为“SourceFile”字符串
#-renamesourcefileattribute SourceFile
#保留行号
-keepattributes SourceFile,LineNumberTable
#保持泛型，保护反射的正常调用
-keepattributes Signature
-keepattributes EnclosingMethod
#忽略警告
-ignorewarning
#保护注解，内部类，签名，异常处理，javascript
-keepattributes *Annotation*, InnerClasses, Signature, Exceptions, JavascriptInterface
    #不混淆哪些类，保持哪些类不被混淆
    -keep public class * extends android.support.v4.app.Fragment
    -keep public class * extends android.app.Fragment
    -keep public class * extends android.app.Activity
    -keep public class * extends android.app.Application
    -keep public class * extends android.app.Service
    -keep public class * extends android.content.BroadcastReceiver
    -keep public class * extends android.content.ContentProvider
    -keep public class * extends android.app.backup.BackupAgentHelper
    -keep public class * extends android.preference.Preference
    -keep public class com.android.vending.licensing.ILicensingService
    -keep public class * extends android.app.Dialog
    -keep class cn.pedant.SweetAlert.**{*;}


     #，保持自定义view不被混淆，或者说不混淆所有View的子类及其子类的get、set方法
        -keep public class * extends android.view.View {
            public <init>(android.content.Context);
            public <init>(android.content.Context, android.util.AttributeSet);
            public <init>(android.content.Context, android.util.AttributeSet, int);
            public void set*(...);
            public *** get*();
        }



        #指定不混淆所有的JNI方法，保持native方法不被混淆
        -keepclasseswithmembernames class * {
            native <methods>;
        }
        #保持自定义控件类不被混淆
        -keepclasseswithmembers class * {
            public <init>(android.content.Context, android.util.AttributeSet);
        }


        #不混淆Activity中参数类型为View的所有方法
        -keepclassmembers class * extends android.app.Activity {
           public void *(android.view.View);
        }


        #保持Parcelable 序列化类不被混淆，或者说不混淆Parcelable和它的子类，还有Creator成员变量
        -keep class * implements android.os.Parcelable {
          public static final android.os.Parcelable$Creator *;
        }

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}



#不混淆Serializable接口，保持所有实现 Serializable 接口的类成员
-keepnames class * implements java.io.Serializable
#不混淆Serializable接口的子类中指定的某些成员变量和方法
-keepclassmembers class * implements java.io.Serializable {
                static final long serialVersionUID;
                private static final java.io.ObjectStreamField[] serialPersistentFields;
                !static !transient <fields>;
                !private <fields>;
                !private <methods>;
                private void writeObject(java.io.ObjectOutputStream);
                private void readObject(java.io.ObjectInputStream);
                java.lang.Object writeReplace();
                java.lang.Object readResolve();
            }


            #不混淆Enum类型的指定方法，如果混淆报错，
            #建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
            #-keepclassmembers enum * {
            #    public static **[] values();
            #    public static ** valueOf(java.lang.String);
            #}


            #不混淆R类里及其所有内部static类中的所有static变量字段
            -keepclassmembers class **.R$* {
                public static <fields>;
            }

            #如果有用到Gson解析包的，直接添加下面这几行就能成功混淆，不然会报错。
            # for gson
            # Gson uses generic type information stored in a class file when working with fields. Proguard
            # removes such information by default, so configure it to keep all of it.
            # -keepattributes Signature
            # Gson specific classes
            -keep class sun.misc.Unsafe { *; }
            -keep class com.google.gson.examples.android.model.** { *; }
            # Application classes that will be serialized/deserialized over Gson
            # javabean 文件不可以被混淆
            -keep class com.biotag.cockowner.JavaBean.**{*;}

            #如果有用到WebView的JS调用接口，需加入如下规则。
            -keepclassmembers class fqcn.of.javascript.interface.for.webview {
               public *;
            }

            -assumenosideeffects class com.biotag.cockowner.common.Log {
                            public static *** d(...);
                            public static *** v(...);
                            public static *** i(...);
                            public static *** djson(...);
                            public static *** dxml(...);
                        }
 # 保持测试相关的代码
 -dontnote junit.framework.**
 -dontnote junit.runner.**
 -dontwarn android.test.**
 -dontwarn android.support.test.**
 -dontwarn org.junit.**

 # for picasso
 -keep class com.squareup.picasso.**{ *; }
 # for baiu 移动统计 ，可在这个网址看到：  https://mtj.baidu.com/web/help/article?id=76&type=0
 -keep class com.baidu.bottom.** { *; }
 -keep class com.baidu.kirin.** { *; }
 -keep class com.baidu.mobstat.** { *; }
 #for EventBus
 -keepattributes *Annotation*
  -keepclassmembers class ** {
      @org.greenrobot.eventbus.Subscribe <methods>;
  }
  -keep enum org.greenrobot.eventbus.ThreadMode { *; }

  # Only required if you use AsyncExecutor
  -keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
      <init>(java.lang.Throwable);
  }
# for okhttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

# for Okio
-dontwarn com.squareup.**
-dontwarn okio.**
-keep public class org.codehaus.* { *; }
-keep public class java.nio.* { *; }