package com.example.demo.batch.process;

import com.example.demo.dto.SalesOrderDTO;
import com.example.demo.entity.SalesOrder;
import com.example.demo.reposDev.SalesOrderRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesDetailProcessor implements ItemProcessor<SalesOrderDTO, SalesOrder> {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public SalesOrder process(final SalesOrderDTO saleDto) throws Exception {
        final SalesOrder salesOrder = new SalesOrder();
        List<SalesOrder> salesOrders = salesOrderRepository.findAll();
        System.out.println("salesOrders=======" + salesOrders.size());
        return salesOrder;
    }
}
