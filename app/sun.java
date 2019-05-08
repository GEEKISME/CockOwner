 #不混淆Serializable接口
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
    -keep class sun.misc.Unsafe { *; }
    -keep class com.google.gson.examples.android.model.** { *; }


    #如果有用到WebView的JS调用接口，需加入如下规则。
    -keepclassmembers class fqcn.of.javascript.interface.for.webview {
       public *;
    }