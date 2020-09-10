<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list">
                <ul class="product-slider product-slick-initialized product-slick-slider">
                    <div class="product-slick-list product-draggable">
                        <div class="product-slick-track" :style="lineWidth">
                            <VueProductItem
                                v-for="productItem in productLineList"
                                :key="productItem.productTitle"
                                :product-item-data="productItem"
                                :item-width="productItemWidth"
                            ></VueProductItem>
                            <VueProductMenuIcon
                                :product-menu-data="productMenuBean"
                                :item-width="productItemWidth"
                            ></VueProductMenuIcon>
                        </div>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    components: {
        VueProductItem: () =>
            import(
                /* webpackChunkName: "ProductLineList" */ "../product-line-list-parts/ProductItem"
            ),
        VueProductMenuIcon: () =>
            import(
                /* webpackChunkName: "ProductLineList" */ "../product-line-list-parts/ProductMenuIcon"
            ),
    },
    props: {
        productMenuBean: {
            type: Object,
            required: false,
        },
        productLineList: {
            type: Array,
            required: false,
        },
    },
    data() {
        return {
            productItemWidth: 160,
        };
    },
    computed: {
        lineWidth() {
            return {
                width:
                    this.productItemWidth * (this.productLineList.length + 1) +
                    `px`,
            };
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./product_line_list_default";
@import "./product_line_list_media";
</style>