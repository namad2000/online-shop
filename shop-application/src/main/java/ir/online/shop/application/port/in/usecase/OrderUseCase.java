package ir.online.shop.application.port.in.usecase;

import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.utils.api.BigDecimalUtil;
import io.qoop.validation.api.IsValid;
import ir.online.shop.application.port.in.mapper.MediaMapper;
import ir.online.shop.application.port.in.mapper.OrderItemMapper;
import ir.online.shop.application.port.in.mapper.OrderMapper;
import ir.online.shop.application.port.in.mapper.ProductMapper;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderCmd;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderItemCmd;
import ir.online.shop.application.port.in.model.result.order.OrderItemResult;
import ir.online.shop.application.port.in.model.result.order.OrderResult;
import ir.online.shop.application.port.in.validator.OrderValidator;
import ir.online.shop.domain.model.Customer;
import ir.online.shop.domain.model.OrderHead;
import ir.online.shop.domain.model.OrderItem;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.domain.service.*;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class OrderUseCase {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderValidator orderValidator;
    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;
    private final CustomerService customerService;
    private final SaleProductService saleProductService;
    private final VendorService vendorService;
    private final ProductMapper productMapper;
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;

    public OrderResult create(@IsValid CreateOrderCmd cmd) {

        orderValidator.checkIfItemsEmpty(cmd.getItems());

        OrderHead newOrder = orderMapper.toDomain(cmd);

        Customer customer = cmd.getCustomerId() == null ? null : customerService.getById(cmd.getCustomerId());

        OrderHead order = orderService.create(newOrder, /*items,*/ customer);

        List<OrderItem> items = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        int totalItems = 0;
        for (CreateOrderItemCmd item : cmd.getItems()) {
            OrderItem orderItem = orderItemMapper.toDomain(item);
            SaleProduct saleProduct = saleProductService.getById(item.getSaleProductId());
            orderItem.setSaleProduct(saleProduct);

            if (!BigDecimalUtil.equals(saleProduct.getOriginalRetailPrice(), item.getPricePerUnit())) {
                //todo generate exception for decide
            }
            totalItems += item.getQuantity();

            orderItem.setPricePerUnit(saleProduct.getRetailPrice());
            BigDecimal sumItemsPrice = item.getPricePerUnit().multiply(BigDecimal.valueOf(item.getQuantity()));

            orderItem.setTotalPrice(sumItemsPrice);
            orderItem.setQuantity(item.getQuantity());

            items.add(orderItem);

            totalPrice = totalPrice.add(sumItemsPrice);
        }

        order.setTotalPrice(totalPrice);
        order.setTotalItems(totalItems);

        items = orderItemService.create(order, items);
        orderService.update(order);

        List<OrderItemResult> itemResults = orderItemMapper.toResult(items);
        OrderResult orderResult = orderMapper.toResult(order);
        orderResult.setItems(itemResults);
        return orderResult;
    }

    public OrderResult getById(UUID orderId) {
        OrderResult orderResult = orderMapper.toResult(orderService.getById(orderId));

        return orderResult;
    }

    public OrderResult getByIdActiveAndNotDeleted(UUID orderId) {
//        OrderResult orderResult = orderMapper.toResult(orderService.getByIdActiveAndNotDeleted(orderId));
//
//        return orderResult;
        return null;
    }

    public List<OrderResult> search(String name, Long minPrice, Long maxPrice, Integer pageNumber, Integer pageSize) {
//        List<OrderHead> orders = orderService.searchByCustomer(name, minPrice, maxPrice, page);
//        List<OrderResult> orderResultList = orderMapper.toResult(orders, null);
//
//        return orderResultList;
        return List.of();
    }
}
