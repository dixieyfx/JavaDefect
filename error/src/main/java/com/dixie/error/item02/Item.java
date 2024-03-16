package com.dixie.error.item02;

import lombok.*;
import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2024/3/16 13:04
 */
@Data
@RequiredArgsConstructor
public class Item {

    final String name; //商品名
    int remaining = 1000; //库存剩余
    @ToString.Exclude
    //ToString不包含这个字段
    ReentrantLock lock = new ReentrantLock();


}
