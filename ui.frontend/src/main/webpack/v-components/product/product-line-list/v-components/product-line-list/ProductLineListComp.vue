<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list">
                <ul
                    class="product-slider product-slick-initialized product-slick-slider"
                    :style="productStyleData.productLineWindow"
                >
                    <SlickArrowFontAwesome
                        v-show="slickData.isNeedShowNextSlick"
                        :is-next-arrow="false"
                    ></SlickArrowFontAwesome>
                    <div class="product-slick-list product-draggable">
                        <div class="product-slick-track" :style="productStyleData.productLineWidth">
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
                        </div>
                    </div>
                    <SlickArrowFontAwesome
                        v-show="slickData.isNeedShowPrevSlick"
                        :is-next-arrow="true"
                    ></SlickArrowFontAwesome>
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
        SlickArrowFontAwesome: () =>
            import(
                /* webpackChunkName: "SlickArrowFontAwesome" */ "@common/slick-arrow-font-awesome/SlickArrowFontAwesome"
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
                productMaxLineItems: 7,
            },
            productStyleData: {
                productLineWindow: 0,
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
                    (this.productLineList.length + 1) +
                `px`,
        };
        this.productStyleData.productLineWindow = {
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