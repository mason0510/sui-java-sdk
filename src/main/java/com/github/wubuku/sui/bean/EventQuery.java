package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type EventQuery =
 * | "All"
 * | { "Transaction": TransactionDigest }
 * | { "MoveModule": { package: ObjectId, module: string } }
 * | { "MoveEvent": string }
 * | { "EventType": EventType }
 * | { "Sender": SuiAddress }
 * | { "Recipient": ObjectOwner }
 * | { "Object": ObjectId }
 * | { "TimeRange": { "start_time": number, "end_time": number } };
 * </pre>
 */
public interface EventQuery {

    @JsonSerialize(using = AllJsonSerializer.class)
    class All implements EventQuery {
        public static All INSTANCE = new All();

        @Override
        public String toString() {
            return "All{}";
        }
    }

    class AllJsonSerializer extends JsonSerializer<All> {
        @Override
        public void serialize(All value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("All");
        }
    }

    class Transaction implements EventQuery {
        @JsonProperty("Transaction")
        private String transaction;

        public Transaction() {
        }

        public Transaction(String transaction) {
            this.transaction = transaction;
        }

        public String getTransaction() {
            return transaction;
        }

        public void setTransaction(String transaction) {
            this.transaction = transaction;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transaction='" + transaction + '\'' +
                    '}';
        }
    }

    class MoveModule implements EventQuery {
        @JsonProperty("MoveModule")
        private MoveModuleProperties moveModule;

        public MoveModule() {
        }

        public MoveModule(String _package, String module) {
            this.moveModule = new MoveModuleProperties(_package, module);
        }

        public MoveModuleProperties getMoveModule() {
            return moveModule;
        }

        public void setMoveModule(MoveModuleProperties moveModule) {
            this.moveModule = moveModule;
        }

        @Override
        public String toString() {
            return "MoveModule{" +
                    "moveModule=" + moveModule +
                    '}';
        }

        public static class MoveModuleProperties {
            @JsonProperty("package")
            private String package_;
            private String module;

            public MoveModuleProperties() {
            }

            public MoveModuleProperties(String package_, String module) {
                this.package_ = package_;
                this.module = module;
            }

            public String getPackage() {
                return package_;
            }

            public void setPackage(String package_) {
                this.package_ = package_;
            }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            @Override
            public String toString() {
                return "MoveModuleProperties{" +
                        "package_='" + package_ + '\'' +
                        ", module='" + module + '\'' +
                        '}';
            }
        }
    }

    class MoveEvent implements EventQuery {
        @JsonProperty("MoveEvent")
        private String moveEvent;

        public MoveEvent() {
        }

        public MoveEvent(String moveEvent) {
            this.moveEvent = moveEvent;
        }

        public String getMoveEvent() {
            return moveEvent;
        }

        public void setMoveEvent(String moveEvent) {
            this.moveEvent = moveEvent;
        }

        @Override
        public String toString() {
            return "MoveEvent{" +
                    "moveEvent='" + moveEvent + '\'' +
                    '}';
        }
    }

    /**
     * From TypeScript definition:
     * <p>
     * <pre>
     * export type EventType =
     * | 'MoveEvent'
     * | 'Publish'
     * | 'TransferObject'
     * | 'MutateObject'
     * | 'CoinBalanceChange'
     * | 'DeleteObject'
     * | 'NewObject'
     * | 'EpochChange'
     * | 'Checkpoint';
     * </pre>
     */
    class EventType implements EventQuery {
        public static final String MOVE_EVENT = "MoveEvent";
        public static final String PUBLISH = "Publish";
        public static final String TRANSFER_OBJECT = "TransferObject";
        public static final String MUTATE_OBJECT = "MutateObject";
        public static final String COIN_BALANCE_CHANGE = "CoinBalanceChange";
        public static final String DELETE_OBJECT = "DeleteObject";
        public static final String NEW_OBJECT = "NewObject";
        public static final String EPOCH_CHANGE = "EpochChange";
        public static final String CHECKPOINT = "Checkpoint";

        @JsonProperty("EventType")
        private String eventType;

        public EventType() {
        }

        public EventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        @Override
        public String toString() {
            return "EventType{" +
                    "eventType='" + eventType + '\'' +
                    '}';
        }
    }

    class Sender implements EventQuery {
        @JsonProperty("Sender")
        private String sender;

        public Sender() {
        }

        public Sender(String sender) {
            this.sender = sender;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        @Override
        public String toString() {
            return "Sender{" +
                    "sender='" + sender + '\'' +
                    '}';
        }
    }

    class Recipient implements EventQuery {
        @JsonProperty("Recipient")
        private ObjectOwner recipient;

        public Recipient() {
        }

        public Recipient(ObjectOwner recipient) {
            this.recipient = recipient;
        }

        public ObjectOwner getRecipient() {
            return recipient;
        }

        public void setRecipient(ObjectOwner recipient) {
            this.recipient = recipient;
        }

        @Override
        public String toString() {
            return "Recipient{" +
                    "recipient=" + recipient +
                    '}';
        }
    }

    class Object implements EventQuery {
        @JsonProperty("Object")
        private String objectId;

        public Object() {
        }

        public Object(String objectId) {
            this.objectId = objectId;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        @Override
        public String toString() {
            return "Object{" +
                    "objectId='" + objectId + '\'' +
                    '}';
        }
    }

    class TimeRange implements EventQuery {
        @JsonProperty("TimeRange")
        private TimeRangeProperties timeRange;

        public TimeRange() {
        }

        public TimeRange(Long startTime, Long endTime) {
            this.timeRange = new TimeRangeProperties(startTime, endTime);
        }

        public TimeRangeProperties getTimeRange() {
            return timeRange;
        }

        public void setTimeRange(TimeRangeProperties timeRange) {
            this.timeRange = timeRange;
        }

        @Override
        public String toString() {
            return "TimeRange{" +
                    "timeRange=" + timeRange +
                    '}';
        }

        public static class TimeRangeProperties {
            @JsonProperty("start_time")
            private Long startTime;
            @JsonProperty("end_time")
            private Long endTime;

            public TimeRangeProperties() {
            }

            public TimeRangeProperties(Long startTime, Long endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(Long startTime) {
                this.startTime = startTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(Long endTime) {
                this.endTime = endTime;
            }

            @Override
            public String toString() {
                return "TimeRangeProperties{" +
                        "startTime=" + startTime +
                        ", endTime=" + endTime +
                        '}';
            }
        }
    }
}