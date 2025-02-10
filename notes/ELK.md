### 1. **로그 수집 및 중앙화**
ELK는 주로 로그 데이터를 수집하고 모니터링하기 위해 사용됩니다. 스프링부트 프로젝트에서 발생하는 다양한 로그를 ELK로 전송하여 중앙에서 관리할 수 있습니다.
#### **Logback을 통해 Elasticsearch로 로그 전송**
스프링부트는 기본적으로 **Logback**을 로깅 프레임워크로 사용합니다. 이를 설정해 ELK와 연결할 수 있습니다.
- **Logstash로 로그 전송 설정**
  Logstash를 ELK의 데이터 수집 파이프라인으로 사용하여 스프링부트 애플리케이션의 로그를 전송합니다. 다음은 Logback 설정 예제입니다:
``` xml
  <!-- logback-spring.xml -->
  <configuration>
      <appender name="Logstash" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
          <destination>127.0.0.1:5044</destination>
          <encoder class="net.logstash.logback.encoder.LogstashEncoder" />
      </appender>

      <root level="INFO">
          <appender-ref ref="Logstash" />
      </root>
  </configuration>
```
- **Elasticsearch로 직접 전송**
  로그를 Logstash 없이 Elasticsearch로 직접 전송하려면 외부 라이브러리를 추가하거나 `LogstashEncoder`를 활용해 구성을 단순화할 수 있습니다.

### 2. **Kibana 대시보드로 로깅 데이터 시각화**
Elasticsearch에 저장된 로그 데이터를 Kibana로 시각화하여 실시간 대시보드를 구성할 수 있습니다. 이를 통해 스프링부트 애플리케이션의 상태나 문제를 모니터링할 수 있습니다.
#### **활용할 수 있는 대시보드 구성**:
- 애플리케이션별 **에러 발생 모니터링 (5xx, 4xx 에러율)**
- **API 성능 분석** (응답시간, 처리량)
- **사용자 활동 추적** (로그인, API 호출 빈도 등)
- **서비스 가용성 (Active/Inactive 상태)**

예를 들어, `Spring Boot Logging` 로그를 기반으로 Kibana에서 다음과 같은 데이터를 분석할 수 있습니다:
- 로그 레벨별 분포 (**INFO**, **WARN**, **ERROR**)
- 발생 빈도가 높은 에러 메시지
- 특정 시간대의 에러 집중도

### 3. **Elastic APM 연동 (Application Performance Monitoring)**
Elastic APM(애플리케이션 성능 모니터링)을 스프링부트 프로젝트에 연동하면 애플리케이션의 성능 병목현상이나 지연 구간을 상세히 추적할 수 있습니다.
#### **APM 연동 설정**
1. **Elastic APM Agent 추가** Maven/Gradle에 APM 의존성을 추가합니다:
``` groovy
   implementation 'co.elastic.apm:elasticsearch-apm-agent:1.35.0'
```
1. **APM 설정(application.yml)** APM 서버와 애플리케이션을 연결합니다:
``` yaml
   elastic.apm:
     service_name: "my-spring-app"
     server_urls: "http://localhost:8200"
     environment: "production"
     application_packages: "project.myblog"
```
1. **모니터링 가능 항목**
    - 요청 처리 시간(Request Latency)
    - 데이터베이스 쿼리 속도 (Hibernate/JPA 연동 쿼리 추적)
    - 외부 API 호출 시간
    - 트랜잭션별 세부 내역

Kibana의 APM 대시보드에서 세부 정보를 확인할 수 있습니다.

### 4. **로그 검색 및 오류 디버깅**
스프링부트에서 발생한 각종 오류나 예외 상황을 ELK를 통해 검색하고 분석할 수 있습니다.
#### 예: 특정 에러 로그의 빠른 검색
`Elasticsearch`의 강력한 검색 기능을 통해 다음과 같은 조건으로 로그를 빠르게 필터링할 수 있습니다.
- 특정 사용자 `username` 관련 에러 추적
- 특정 API 경로(`/api/v1/users/...`) 요청 내역
- 발생 시간별 이벤트 분석

Kibana에서 쿼리를 사용하여 직접 검색하거나 REST API를 통해 Elasticsearch 데이터에 접근할 수도 있습니다:
``` bash
GET /logs-index/_search
{
  "query": {
    "match": {
      "message": "java.lang.NullPointerException"
    }
  }
}
```
### 5. **Custom 이벤트 로깅**
일반적인 로그 데이터 외에도, 특정 비즈니스 이벤트를 로깅하여 ELK로 전송할 수 있습니다.
#### 예를 들어:
- **사용자 활동 기록**
``` java
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;

  public void logUserEvent(String username, String action) {
      Logger logger = LoggerFactory.getLogger("UserActivityLogger");
      logger.info("User [{}] performed [{}] action", username, action);
  }
```
- **주요 비즈니스 이벤트 모니터링**
    - 주문 생성 시 이벤트 기록
    - 특정 조건의 경고 메시지 (예: 서비스 응답 시간이 너무 길 경우)

해당 데이터는 Kibana로 전송되어 대시보드에서 실시간으로 추적 가능합니다.
### 6. **추가적인 활용 방안**
1. **Alert 설정** Kibana에서 조건을 설정해 특정 이벤트가 발생하면 알림(이메일, Slack)을 전송하도록 구성할 수 있습니다.
    - 예: 에러 로그(`ERROR` 레벨)가 10분 내 100건 이상 발생하면 Slack 알림 발송.

2. **애플리케이션 상태 기반 스케일링** ELK 데이터를 클라우드 기반의 모니터링/스케일링 도구와 연동하여 애플리케이션의 자동 스케일링을 구현할 수 있습니다.
    - 예: CPU 사용량과 요청 수를 분석해 인스턴스 자동 증가/감소.

3. **트래픽 히트맵 분석**
    - 어떤 API가 가장 많이 호출되는지, 어떤 시간대에 트래픽이 집중되는지 파악.
    - 이를 통해 애플리케이션 구조를 최적화하거나 캐싱 전략 도입 가능.

### 최종적으로 기대할 효과
- **문제 탐지 및 해결 시간 단축**: 로그를 중앙화 및 시각화할 수 있어 디버깅 및 오류 해결이 빠르게 이루어집니다.
- **성능 최적화**: Elastic APM 및 다른 데이터 분석을 통해 애플리케이션 성능 병목을 확인하고 개선할 수 있습니다.
- **비즈니스 가시성 증대**: 애플리케이션 내에서 발생하는 모든 활동(사용자 행동, 이벤트)을 기록하여 데이터 기반의 의사결정 가능.
