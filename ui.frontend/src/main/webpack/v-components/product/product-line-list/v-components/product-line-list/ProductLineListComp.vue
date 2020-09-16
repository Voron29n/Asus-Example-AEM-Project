<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list">
                <ul
                    class="product-slider product-slick-initialized product-slick-slider"
                    :style="widthWindowProductLineList"
                >
                    <SlickArrowFontAwesome
                        v-show="!isSmallVersion && slickData.isNeedShowPrevSlick"
                        :is-next-arrow="false"
                        @change-slick-arrow-font-awesome="changeBySlickArrow"
                    ></SlickArrowFontAwesome>
                    <div class="product-slick-list product-draggable">
                        <div
                            class="product-slick-track"
                            :style="[widthProductLineList,productStyleData]"
                        >
                            <VueProductItem
                                v-for="productItem in productLineList"
                                :key="productItem.productTitle"
                                :product-item-data="productItem"
                                :item-width="widthProductLineItem"
                            ></VueProductItem>
                            <VueProductMenuIcon
                                :product-menu-data="productMenuBean"
                                :item-width="widthProductLineItem"
                            ></VueProductMenuIcon>
                        </div>
                    </div>
                    <SlickArrowFontAwesome
                        v-show="!isSmallVersion && slickData.isNeedShowNextSlick"
                        :is-next-arrow="true"
                        @change-slick-arrow-font-awesome="changeBySlickArrow"
                    ></SlickArrowFontAwesome>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
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
            activeProductTab: 0,
            productStyleData: {
                transform: "",
                transition: "all 0.25s ease 0s",
            },
            productItemsInLine: {
                currentCount: 0,
                countSmallVersion: 4,
                countMediumVersion: 5,
                countLargeVersion: 7,
                widthLargeVersion: 160,
            },
            productWindowType: {
                small: "small",
                medium: "medium",
                large: "large",
            },
            slickData: {
                isNeedShowNextSlick: true,
                isNeedShowPrevSlick: true,
            },
        };
    },
    mounted () {
        this.setDefaultStatusSlickArrow();
    },
    methods: {
        setDefaultStatusSlickArrow(){
            if (this.isSelectedFirstTab && this.isNeedShowSlickArrows){
                this.changeShowStatusSlickArrow(false, true)
            } else if (this.isSelectedLastTab && this.isNeedShowSlickArrows) {
                this.changeShowStatusSlickArrow(true, false)
            }
        },
        changeBySlickArrow(isNextArrow) {
            let isSlickChangeEnable =
                this.productLineList.length >
                this.productItemsInLine.currentCount;
            if (isNextArrow && this.countProductTab > 1) {
                this.activeProductTab =
                    this.isSelectedLastTab
                        ? this.activeProductTab
                        : this.activeProductTab + 1;
                if (this.isSelectedLastTab) {
                    this.updateTransformForLastTab();
                    this.changeShowStatusSlickArrow(true, false);
                } else {
                    this.updateTransformByActiveProductTab();
                    this.changeShowStatusSlickArrow(true, true);
                }
            } else if (!isNextArrow && this.countProductTab > 1) {
                this.activeProductTab = this.isSelectedFirstTab
                    ? this.activeProductTab
                    : this.activeProductTab - 1;
                if (this.isSelectedFirstTab) {
                    this.productStyleData.transform = `translateX(0px)`;
                    this.changeShowStatusSlickArrow(false, true);
                } else {
                    this.updateTransformByActiveProductTab();
                    this.changeShowStatusSlickArrow(true, true);
                }
            }
        },
        updateTransformByActiveProductTab() {
            let itemToTransform =
                this.activeProductTab * this.productItemsInLine.currentCount;
            this.productStyleData.transform = `translateX(${
                -itemToTransform * this.widthProductLineItem
            }px)`;
        },
        updateTransformForLastTab() {
            let itemToTransform =
                this.productLineList.length +
                1 -
                this.productItemsInLine.currentCount;
            this.productStyleData.transform = `translateX(${
                -itemToTransform * this.widthProductLineItem
            }px)`;
        },
        updateTransformForFirstTab() {
            this.productStyleData.transform = `translateX(0px)`;
        },
        changeShowStatusSlickArrow(statusToChangePrev, statusToChangeNext) {
            this.slickData.isNeedShowPrevSlick = statusToChangePrev;
            this.slickData.isNeedShowNextSlick = statusToChangeNext;
        },
    },
    computed: {
        productWindowVersion() {
            if (this.currentWidth <= 480) {
                return this.productWindowType.small;
            } else if (this.currentWidth > 480 && this.currentWidth <= 1200) {
                return this.productWindowType.medium;
            } else {
                return this.productWindowType.large;
            }
        },
        widthProductLineItem() {
            let itemWidth = 0;
            switch (this.productWindowVersion) {
                case this.productWindowType.small:
                    itemWidth =
                        this.currentWidth /
                        this.productItemsInLine.countSmallVersion;
                    if (itemWidth > 100) {
                        this.productItemsInLine.currentCount = this.productItemsInLine.countSmallVersion;
                    } else {
                        itemWidth =
                            this.currentWidth /
                            (this.productItemsInLine.countSmallVersion - 1);
                        this.productItemsInLine.currentCount = this.productItemsInLine.countSmallVersion;
                    }
                    break;
                case this.productWindowType.medium:
                    itemWidth =
                        (this.currentWidth - 150) /
                        this.productItemsInLine.countMediumVersion;
                    if (itemWidth > 130) {
                        this.productItemsInLine.currentCount = this.productItemsInLine.countSmallVersion;
                    } else {
                        itemWidth =
                            this.currentWidth /
                            (this.productItemsInLine.countMediumVersion - 1);
                        this.productItemsInLine.currentCount = this.productItemsInLine.countMediumVersion;
                    }
                    break;
                case this.productWindowType.large:
                    itemWidth = this.productItemsInLine.widthLargeVersion;
                    this.productItemsInLine.currentCount = this.productItemsInLine.countLargeVersion;
                    break;
                default:
                    break;
            }

            return itemWidth;
        },
        widthProductLineList() {
            return {
                width:
                    (this.productLineList.length + 1) *
                        this.widthProductLineItem +
                    `px`,
            };
        },
        widthWindowProductLineList() {
            let windowWidth = 0;
            switch (this.productWindowVersion) {
                case this.productWindowType.small:
                    windowWidth = this.currentWidth;
                    break;
                case this.productWindowType.medium:
                    windowWidth = this.currentWidth - 150;
                    break;
                case this.productWindowType.large:
                    windowWidth =
                        this.widthProductLineItem *
                        this.productItemsInLine.countLargeVersion;
                    break;
                default:
                    break;
            }
            return {
                width: windowWidth + `px`,
            };
        },
        countProductTab() {
            let tabsValue =
                (this.productLineList.length + 1) /
                this.productItemsInLine.currentCount;
            tabsValue = tabsValue <= 1 ? 1 : Math.ceil(tabsValue);
            return tabsValue;
        },
        isNeedShowSlickArrows() {
            return this.countProductTab !== 1 
        },
        isSmallVersion() {
            return this.productWindowVersion === this.productWindowType.small;
        },
        isSelectedFirstTab() {
            return (
                this.activeProductTab === 0
            );
        },
        isSelectedLastTab() {
            return this.activeProductTab +1  === this.countProductTab;
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./product_line_list_default";
@import "./product_line_list_media";
</style>