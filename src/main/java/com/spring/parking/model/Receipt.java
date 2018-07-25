package com.spring.parking.model;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
@Service
public class Receipt {

        private String id;

        public Receipt() {
            this.id = "receipt: "+UUID.randomUUID().toString();
        }
        public Receipt(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setID(String s) {
            this.id=s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Receipt card = (Receipt) o;
            return Objects.equals(id, card.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

}
