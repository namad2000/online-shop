//package ir.online.shop.presentation.rest;
//
//import ir.online.commons.domain.model.PageData;
//import ir.online.shop.application.port.in.model.cmd.brand.CreateBrandCmd;
//import ir.online.shop.application.port.in.model.cmd.brand.UpdateBrandCmd;
//import ir.online.shop.application.port.in.usecase.BrandUseCase;
//import ir.online.shop.presentation.rest.dto.req.brand.CreateBrandRequest;
//import ir.online.shop.presentation.rest.dto.req.brand.UpdateBrandRequest;
//import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
//import ir.online.shop.presentation.rest.mapper.BrandCommandMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/brand")
//@RequiredArgsConstructor
//public class BrandResource {
//
//    private final BrandUseCase brandUseCase;
//    private final BrandCommandMapper brandCommandMapper;
//
//    @PostMapping("/create")
//    public UUID create(@RequestBody CreateBrandRequest request) {
//        CreateBrandCmd command = brandCommandMapper.toCommand(request);
//        return brandUseCase.create(command);
//    }
//
//    @PutMapping("/{id}")
//    public UUID update(
//            @PathVariable UUID id,
//            @RequestBody UpdateBrandRequest request) {
//
//        UpdateBrandCmd command = brandCommandMapper.toCommand(id, request);
//        return brandUseCase.update(command);
//    }
//
//    @GetMapping("/{id}")
//    public BrandResponse getById(@PathVariable UUID id) {
//        return brandCommandMapper.toResponse(
//                brandUseCase.getById(id)
//        );
//    }
//
//    @GetMapping("/all")
//    public PageData<BrandResponse> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
//                                          @RequestParam(defaultValue = "10") Integer pageSize) {
//        return brandCommandMapper.toResponseList(brandUseCase.getAll(pageNumber, pageSize));
//    }
//
//    @GetMapping("/search")
//    public PageData<BrandResponse> search(@RequestParam(required = false) String name,
//                                          @RequestParam(defaultValue = "0") Integer pageNumber,
//                                          @RequestParam(defaultValue = "10") Integer pageSize) {
//        return brandCommandMapper.toResponseList(
//                brandUseCase.search(name, pageNumber, pageSize)
//        );
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable UUID id) {
//        brandUseCase.delete(id);
//    }
//
//}
