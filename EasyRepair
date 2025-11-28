## CIAS EasyRepair Architecture Diagram

```mermaid
graph TB
    %% 这里粘贴完整的 Mermaid 代码（包括 classDef、subgraph、连接关系等）
    classDef client fill:#e8f4f8,stroke:#2b6cb0,stroke-width:1px;
    classDef access fill:#f0f8fb,stroke:#3182ce,stroke-width:1px;
    classDef gateway fill:#fdf2f8,stroke:#9f7aea,stroke-width:1px;
    classDef core fill:#f5fafe,stroke:#38b2ac,stroke-width:1px;
    classDef infra fill:#faf6ed,stroke:#ed8936,stroke-width:1px;
    classDef external fill:#f5f5f5,stroke:#4a5568,stroke-width:1px;

    subgraph "🔹 Client Layer (客户端层)"
        direction row
        C1["中保运营人员"]:::client
        C2["保司主管"]:::client
        C3["保司坐席"]:::client
        C4["保司查勘员"]:::client
        C5["维修厂管理员"]:::client
        C6["维修厂作业人员"]:::client
    end

    subgraph "🔹 Access Channels (接入渠道)"
        direction row
        PC["PC端"]:::access
        H5["H5端"]:::access
        APP["APP控制"]:::access
    end

    subgraph "🔹 Gateway Layer (API网关)"
        GCGateway["GC-Gateway<br/>统一路由/权限控制"]:::gateway
    end

    subgraph "🔹 Core Service Layer (核心服务层)"
        direction row
        Dispatch["调度服务<br/>cias-gc-dispatch"]:::core
        EasyRepair["主服务（核心）<br/>cias-easyrepair"]:::core
        Analysis["短信解析服务<br/>cias-gc-analysis"]:::core
        CaseCenter["外部对接服务<br/>cias-gc-casecenter"]:::core
    end

    subgraph "🔸 External Services (外部服务)"
        direction col
        userCenter["用户中心<br/>userCenter"]:::external
        doraemon["文档服务<br/>doraemon"]:::external
        zbcfPay["支付服务<br/>zbcf-pay"]:::external
        virtualNumber["虚拟号码服务<br/>cias-virtualNumber"]:::external
        aiAgent["AI平台<br/>ffagent"]:::external
        media["影像服务<br/>zbcf-media"]:::external
        sms["短信服务<br/>zbcf-sms"]:::external
        pigeonrace["消息中心<br/>pigeonrace"]:::external
        settlement["结算服务<br/>settlement"]:::external
    end

    subgraph "🔹 Infrastructure Layer (基础设施层)"
        direction row
        Redis["Redis<br/>缓存"]:::infra
        MySQL["MySQL<br/>数据库"]:::infra
        Nacos["Nacos<br/>注册/配置"]:::infra
        RocketMQ["RocketMQ<br/>消息队列"]:::infra
    end

    C1 -->|HTTPS| PC
    C2 -->|HTTPS| PC
    C3 -->|HTTPS| H5
    C4 -->|HTTPS| H5
    C5 -->|HTTPS| APP
    C6 -->|HTTPS| APP

    PC -->|HTTPS| GCGateway
    H5 -->|HTTPS| GCGateway
    APP -->|HTTPS| GCGateway

    GCGateway -->|RPC/HTTP| EasyRepair
    GCGateway -->|RPC/HTTP| Dispatch
    GCGateway -->|RPC/HTTP| Analysis
    GCGateway -->|RPC/HTTP| CaseCenter

    Dispatch -->|Feign| EasyRepair
    Analysis -->|Feign| EasyRepair
    CaseCenter -->|Feign| EasyRepair

    EasyRepair -.->|Feign| userCenter
    EasyRepair -.->|Feign| doraemon
    EasyRepair -.->|Feign| zbcfPay
    EasyRepair -.->|Feign| virtualNumber
    EasyRepair -.->|Feign| aiAgent
    Dispatch -.->|Feign| sms
    Dispatch -.->|Feign| pigeonrace
    CaseCenter -.->|Feign| media
    CaseCenter -.->|Feign| settlement
    Analysis -.->|Feign| media

    EasyRepair --> Redis
    Dispatch --> Redis
    Analysis --> Redis
    CaseCenter --> Redis

    EasyRepair --> MySQL
    Dispatch --> MySQL
    Analysis --> MySQL
    CaseCenter --> MySQL

    EasyRepair --> Nacos
    Dispatch --> Nacos
    Analysis --> Nacos
    CaseCenter --> Nacos

    Dispatch --> RocketMQ
    Analysis --> RocketMQ

    linkStyle default stroke:#999,stroke-width:0.8px,stroke-dasharray:0;
    linkStyle 10-18 stroke:#666,stroke-width:0.8px,stroke-dasharray:3,3;
