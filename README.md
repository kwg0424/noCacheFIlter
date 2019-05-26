# NoCacheFilter for Web Application
NoCacheFilter is a device for managing and preventing phenomenon such as caching static resources of Web Browser(Chrome, Internet Explorer,,,)

> from
```xml
<link rel="stylesheet" href="/resources/css/font-awesome.css">
```

> to
```xml
<link rel="stylesheet" href="/resources/css/font-awesome.css?_noCache=aOruOMSkPqm">
```

## Installing NoCacheFilter

* maven
```xml
<dependency>
   <groupId>com.github.kwg0424</groupId>
   <artifactId>noCacheFilter</artifactId>
   <version>1.0.0</version>
</dependency>
```

* Gradle
```text
compile 'com.github.kwg0424:noCacheFilter:1.0.0'
```

* Ivy
```xml
<dependency org='com.github.kwg0424' name='noCacheFilter' rev='1.0.0'>
   <artifact name='noCacheFilter' ext='pom' ></artifact>
</dependency>
```

## Usage

> default

```xml
<filter>
   <filter-name>noCacheFilter</filter-name>
   <filter-class>com.filter.NoCacheFilter</filter-class>
</filter>
<filter-mapping>
   <filter-name>noCacheFilter</filter-name>
   <url-pattern>*.do</url-pattern>
</filter-mapping>
```

> option

If you want to designate any other resouces, add parameters. (`css=href` or `js=src, css=href`, default : remove param is `js=src, css=href`)
```xml
<filter>
   <filter-name>noCacheFilter</filter-name>
   <filter-class>com.filter.NoCacheFilter</filter-class>
   <init-param>
      <param-name>resourcess</param-name>
      <param-value>js=src, css=href</param-value>
   </init-param>
</filter>
<filter-mapping>
   <filter-name>noCacheFilter</filter-name>
   <url-pattern>*.do</url-pattern>
</filter-mapping>
```


If you need update with the specified time pattern, add patternType parameter like this : `yyyy-MM-dd-HHmmss`(typeof SimpleDateFormat), `disabled` , default : remove param is `uuid`)

```xml
<filter>
   <filter-name>noCacheFilter</filter-name>
   <filter-class>com.filter.NoCacheFilter</filter-class>
   <init-param>
      <param-name>patternType</param-name>
      <param-value>yyyy-MM-dd-HHmmss</param-value>
   </init-param>
</filter>
<filter-mapping>
   <filter-name>noCacheFilter</filter-name>
   <url-pattern>*.do</url-pattern>
</filter-mapping>
```

If you need version control, add patternType parameter like this : `yyyy-MM-dd-HHmmss`(typeof SimpleDateFormat), `disabled`

```xml
<filter>
   <filter-name>noCacheFilter</filter-name>
   <filter-class>com.filter.NoCacheFilter</filter-class>
   <init-param>
      <param-name>patternType</param-name>
      <param-value>v=1947</param-value>
   </init-param>
</filter>
<filter-mapping>
   <filter-name>noCacheFilter</filter-name>
   <url-pattern>*.do</url-pattern>
</filter-mapping>
```

## Issue & Support

Support for NoCacheFilter is available through the [github](//github.com/kwg0424/noCacheFIlter/issues) are available.


## License

NoCacheFilter is release under the [apache2.0](//opensource.org/licenses/apache2.0.php).
