<template>
    <li class="product-slick-slide product-slick-active">
        <a
            class="product-af-link-block"
            :href="productItemData.productItemLink.linkTo"
            :target="productItemData.productItemLink.linkUrlTarget"
        >
            <div class="product-info-block">
                <div class="product-block-img">
                    <img :src="productItemData.fileReference" />
                </div>
                <div class="product-block-info">
                    <div class="product-title">{{productItemData.productTitle}}</div>
                    <div class="product-desc">{{productItemData.productDescription}}</div>
                </div>
            </div>
        </a>
    </li>
</template>

<script>
export default {
    props: {
        productItemData: {
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