package com.bagus.gen_24_java_springboot_pos.entity.api;

import lombok.Data;
import java.util.List;

@Data
public class RajaOngkirResponse {
    private RajaOngkir rajaongkir;

    @Data
    public static class RajaOngkir {
        private Query query;
        private Status status;
        private OriginDetails origin_details;
        private DestinationDetails destination_details;
        private List<Result> results;

        @Data
        public static class Query {
            private String origin;
            private String destination;
            private int weight;
            private String courier;
        }

        @Data
        public static class Status {
            private int code;
            private String description;
        }

        @Data
        public static class OriginDetails {
            private String city_id;
            private String province_id;
            private String province;
            private String type;
            private String city_name;
            private String postal_code;
        }

        @Data
        public static class DestinationDetails {
            private String city_id;
            private String province_id;
            private String province;
            private String type;
            private String city_name;
            private String postal_code;
        }

        @Data
        public static class Result {
            private String code;
            private String name;
            private List<Cost> costs;

            @Data
            public static class Cost {
                private String service;
                private String description;
                private List<CostDetail> cost;

                @Data
                public static class CostDetail {
                    private int value;
                    private String etd;
                    private String note;
                }
            }
        }
    }
}