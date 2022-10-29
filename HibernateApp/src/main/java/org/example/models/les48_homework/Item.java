package org.example.models.les48_homework;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {



    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(name = "item")
    private String item;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id" )
    private Person whoseItem;


    public Person getWhoseItem() {
        return whoseItem;
    }

    public void setWhoseItem(Person whoseItem) {
        this.whoseItem = whoseItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", item='" + item + '\'' +
                '}';
    }

    public Item() {
    }

    public Item(String item, Person person) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
