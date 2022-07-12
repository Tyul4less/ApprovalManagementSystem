{
        "info": {
        "_postman_id": "a227d76a-d9b8-4194-94d6-a99dfe382258",
        "name": "쿠푸마케팅-Coupon",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
        "_exporter_id": "1676380"
        },
        "item": [
        {
        "name": "제공 연동 상품 리스트 조회",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "urlencoded",
        "urlencoded": [
        {
        "key": "CODE",
        "value": "1397",
        "type": "text"
        },
        {
        "key": "PASS",
        "value": "paymint1397",
        "type": "text"
        },
        {
        "key": "DOCCODE",
        "value": "1397000",
        "type": "text"
        }
        ]
        },
        "url": {
        "raw": "http://issuev3apitest.m2i.kr:9999/serviceapi.asmx/ServiceCouponList",
        "protocol": "http",
        "host": [
        "issuev3apitest",
        "m2i",
        "kr"
        ],
        "port": "9999",
        "path": [
        "serviceapi.asmx",
        "ServiceCouponList"
        ]
        }
        },
        "response": []
        },
        {
        "name": "상품정보조회",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://issuev3apitest.m2i.kr:9999/serviceapi.asmx/ServiceCouponInfo?CODE=1397&PASS=paymint1397&COUPONCODE=00A3110800002",
        "protocol": "http",
        "host": [
        "issuev3apitest",
        "m2i",
        "kr"
        ],
        "port": "9999",
        "path": [
        "serviceapi.asmx",
        "ServiceCouponInfo"
        ],
        "query": [
        {
        "key": "CODE",
        "value": "1397"
        },
        {
        "key": "PASS",
        "value": "paymint1397"
        },
        {
        "key": "COUPONCODE",
        "value": "00A3110800002"
        }
        ]
        }
        },
        "response": []
        },
        {
        "name": "쿠폰발급-단일발급(기본)",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://issuev3apitest.m2i.kr:9999/serviceapi.asmx/ServiceCouponCreate?CODE=1397&PASS=paymint1397&COUPONCODE=00A3110800002&SEQNUMBER=2022.06.28.17.50.001",
        "protocol": "http",
        "host": [
        "issuev3apitest",
        "m2i",
        "kr"
        ],
        "port": "9999",
        "path": [
        "serviceapi.asmx",
        "ServiceCouponCreate"
        ],
        "query": [
        {
        "key": "CODE",
        "value": "1397"
        },
        {
        "key": "PASS",
        "value": "paymint1397"
        },
        {
        "key": "COUPONCODE",
        "value": "00A3110800002"
        },
        {
        "key": "SEQNUMBER",
        "value": "2022.06.28.17.50.001"
        }
        ]
        }
        },
        "response": []
        },
        {
        "name": "MMS(쿠폰) 이미지 및 정보 제공",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://issuev3apitest.m2i.kr:9999/app/appapi.asmx/AppMMSData?CODE=1397&PASS=paymint1397&GUCODE=01&PINNUMBER=315071363534",
        "protocol": "http",
        "host": [
        "issuev3apitest",
        "m2i",
        "kr"
        ],
        "port": "9999",
        "path": [
        "app",
        "appapi.asmx",
        "AppMMSData"
        ],
        "query": [
        {
        "key": "CODE",
        "value": "1397"
        },
        {
        "key": "PASS",
        "value": "paymint1397"
        },
        {
        "key": "GUCODE",
        "value": "01"
        },
        {
        "key": "PINNUMBER",
        "value": "315071363534"
        }
        ]
        }
        },
        "response": []
        },
        {
        "name": "MMS(쿠폰) 바코드 및 정보 제공 – 이미지크기 조절",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://issuev3apitest.m2i.kr:9999/app/appapi.asmx/AppMMSData_02?CODE=1397&PASS=paymint1397&GUCODE=01&PINNUMBER=315071363534&BARCODEWIDTH=240&BARCODEHEIGHT=180",
        "protocol": "http",
        "host": [
        "issuev3apitest",
        "m2i",
        "kr"
        ],
        "port": "9999",
        "path": [
        "app",
        "appapi.asmx",
        "AppMMSData_02"
        ],
        "query": [
        {
        "key": "CODE",
        "value": "1397"
        },
        {
        "key": "PASS",
        "value": "paymint1397"
        },
        {
        "key": "GUCODE",
        "value": "01"
        },
        {
        "key": "PINNUMBER",
        "value": "315071363534"
        },
        {
        "key": "BARCODEWIDTH",
        "value": "240"
        },
        {
        "key": "BARCODEHEIGHT",
        "value": "180"
        }
        ]
        }
        },
        "response": []
        },
        {
        "name": "manager-제공 연동 상품 리스트 조회",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\n    \"service\" : \"쿠프\"\n}",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:10023/item-present/item-list",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "10023",
        "path": [
        "item-present",
        "item-list"
        ]
        }
        },
        "response": []
        },
        {
        "name": "manager-상품연동조회",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\n    \"service\" : \"쿠프\",\n    \"couponCode\": \"00A3110800002\"\n}",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:10023/item-present/item-detail",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "10023",
        "path": [
        "item-present",
        "item-detail"
        ]
        }
        },
        "response": []
        },
        {
        "name": "manager-쿠폰생성, 상세조회",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\n    \"service\" : \"쿠프\",\n    \"couponCode\": \"00A3110800002\"\n}",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:10023/item-present/coupon-create",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "10023",
        "path": [
        "item-present",
        "coupon-create"
        ]
        }
        },
        "response": []
        }
        ]
        }