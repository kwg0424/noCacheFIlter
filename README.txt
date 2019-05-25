NoCacheFilter는 Web Browser(Chrome, Internet Explorer ...)의 정적인 script(css, js)의 저장(caching)하는 현상을 관리 및 방지할 수 있는 Filter이다.
사용 목적
  개발자의 웹 개발시에 Web Browser의 cache를 지니고 있어서 계속 clear해줘야하는 문제점.
  client에게 새로운 script를 강제로 배포해야되는 경우


사용법
특정 날짜로 버전관리
  minute, hour, day, month, year, disabled
명시가 없으면 정적인 스크립트에 자동으로 일회성인 uuid 추가



<filter>
<filter-name>noCacheFilter</filter-name>
<filter-class>com.NoCacheFilter</filter-class>
</filter>
<filter-mapping>
<filter-name>noCacheFilter</filter-name>
<url-pattern>*.do</url-pattern>
</filter-mapping>