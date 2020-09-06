<template>
    <li class="product-slick-slide product-slick-active">
        <a
            class="product-af-link-block"
            href="//www.asus.com/ru/Laptops/All-Series/"
        >
            <div class="product-info-block">
                <div class="product-block-img">
                    <span class="product-icon-af-all"></span>
                </div>
                <div class="product-block-info">
                    <div class="product-title">Все модели</div>
                </div>
            </div>
        </a>
    </li>
</template>

<script>
export default {
    props: {
        productMenuData: {
            type: Object,
            required: false,
        },
    },
};
</script>

<style lang="scss" scoped>
@import "./product_line_list_part_default";
@import "./product_line_list_part_media";
</style>
