<template>
    <li class="product-slick-slide product-slick-active" :style="{width: itemWidth + `px`}">
        <a
            class="product-af-link-block"
            :href="productMenuData.productMenuLink.linkTo"
            :target="productMenuData.productMenuLink.linkUrlTarget"
        >
            <div class="product-info-block">
                <div class="product-block-icon">
                    <i :class="productMenuData.iconClass"></i>
                </div>
                <div class="product-block-info product-menu-icon">
                    <div class="product-title">{{productMenuData.menuTitle}}</div>
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
        itemWidth: {
            type: Number,
            required: true
        }
    },
};
</script>

<style lang="scss" scoped>
@import "./product_line_list_part_default";
@import "./product_line_list_part_media";
</style>
