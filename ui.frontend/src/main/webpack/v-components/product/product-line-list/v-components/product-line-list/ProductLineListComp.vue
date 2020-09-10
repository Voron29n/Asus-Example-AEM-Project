<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list">
                <ul class="product-slider product-slick-initialized product-slick-slider">
                    <div class="product-slick-list product-draggable">
                        <div class="product-slick-track" :style="lineWidth">
                            <v-product-item
                                v-for="productItem in productLineList"
                                :key="productItem.productTitle"
                                :product-item-data="productItem"
                                :item-width="productItemWidth"
                            ></v-product-item>
                            <v-product-menu-icon
                                :product-menu-data="productMenuBean"
                                :item-width="productItemWidth"
                            ></v-product-menu-icon>
                        </div>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import ProductLineList_ProductItem from "../product-line-list-parts/ProductItem";
import ProductLineList_ProductMenuIcon from "../product-line-list-parts/ProductMenuIcon";

export default {
    components: {
        "v-product-item": ProductLineList_ProductItem,
        "v-product-menu-icon": ProductLineList_ProductMenuIcon,
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
            productItemWidth: 160
        };
    },
    computed: {
        lineWidth() {
            return {
                width:
                    this.productItemWidth * (this.productLineList.length + 1) + `px`,
            };
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./product_line_list_default";
@import "./product_line_list_media";
</style>