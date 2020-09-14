<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list">
                <ul class="product-slider product-slick-initialized product-slick-slider">
                    <div class="product-slick-list product-draggable">
                        <div class="product-slick-track" :style="productStyleData.productLineWidth">
                            <SlickArrowNext v-show="slickData.isNeedShowNextSlick"></SlickArrowNext>
                            <VueProductItem
                                v-for="productItem in productLineList"
                                :key="productItem.productTitle"
                                :product-item-data="productItem"
                                :item-width="productTemplateData.productItemWidth"
                            ></VueProductItem>
                            <VueProductMenuIcon
                                :product-menu-data="productMenuBean"
                                :item-width="productTemplateData.productItemWidth"
                            ></VueProductMenuIcon>
                            <SlickArrowPrev v-show="slickData.isNeedShowPrevSlick"></SlickArrowPrev>
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
        SlickArrowNext: () =>
            import(
                /* webpackChunkName: "SlickArrowNext" */ "@common/slick-arrow-font-awesome/SlickArrowNext"
            ),
        SlickArrowPrev: () =>
            import(
                /* webpackChunkName: "SlickArrowPrev" */ "@common/slick-arrow-font-awesome/SlickArrowPrev"
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
            activeProductId: 0,
            productTemplateData: {
                productItemWidth: 160,
                productMaxLineItems: 8,
            },
            productStyleData: {
                productLineWidth: 0,
            },
            slickData: {
                isNeedShowNextSlick: true,
                isNeedShowPrevSlick: true,
            },
        };
    },
    methods: {
        updateStyle() {},
    },
    mounted() {
        this.productStyleData.productLineWidth = {
            width:
                this.productTemplateData.productItemWidth *
                    this.productTemplateData.productMaxLineItems +
                `px`,
        };
    },
    computed: {
        transformStyleObject() {
            return {
                transform: `translateX(${
                    this.activeProductId *
                    this.productTemplateData.productItemWidth
                }px)`,
            };
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./product_line_list_default";
@import "./product_line_list_media";
</style>