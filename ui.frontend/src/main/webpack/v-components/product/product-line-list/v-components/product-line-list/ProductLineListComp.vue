<template>
    <div class="product-block-list product-line-list">
        <div class="product-block-inner">
            <div class="product-info-block-list" @mouseup="stopMove" @touchend="stopMove">
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
                            @mousedown="startMove"
                            @mousemove="doMove"
                            @touchstart="startMove"
                            @touchmove="doMove"
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
            moveData: {
                startPositionX: 0,
                movePositionX: 0,
                isMouseDown: false,
                isMoveStart: false,
                startTransformValue: 0,
            },
            currentTransformValue: 0,
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
            defaultStyleData: {
                allowTransition: "all 0.5s ease 0s",
                disableTransition: "none",
            },
        };
    },
    methods: {
        changeBySlickArrow(isNextArrow) {
            if (this.countProductTab <= 1) {
                return;
            } else {
                if (isNextArrow) {
                    this.activeProductTab = this.isSelectedLastTab
                        ? this.activeProductTab
                        : this.activeProductTab + 1;
                } else {
                    this.activeProductTab = this.isSelectedFirstTab
                        ? this.activeProductTab
                        : this.activeProductTab - 1;
                }
                if (this.isSelectedLastTab) {
                    this.updateTransformForLastTab();
                } else if (this.isSelectedFirstTab) {
                    this.updateTransformForFirstTab();
                } else {
                    this.updateTransformByActiveProductTab();
                }
            }
        },
        updateTransformByActiveProductTab() {
            let itemToTransform =
                this.activeProductTab * this.productItemsInLine.currentCount;
            this.currentTransformValue =
                -itemToTransform * this.widthProductLineItem;
        },
        updateTransformForLastTab() {
            let itemToTransform =
                this.productLineList.length +
                1 -
                this.productItemsInLine.currentCount;
            this.currentTransformValue =
                -itemToTransform * this.widthProductLineItem;
        },
        updateTransformForFirstTab() {
            this.currentTransformValue = 0;
        },
        startMove(event) {
            this.moveData.startPositionX = this.isTouchEvent(event)
                ? event.touches[0].clientX
                : event.clientX;
            this.moveData.isMouseDown = this.isTouchEvent(event)
                ? this.moveData.isMouseDown
                : true;
            this.moveData.startTransformValue = this.currentTransformValue;
            this.moveData.isMoveStart = true;
        },
        doMove(event) {
            if (this.moveData.isMoveStart) {
                this.moveData.movePositionX = this.isTouchEvent(event)
                    ? event.touches[0].clientX
                    : event.clientX;

                let movedWidth =
                    this.moveData.movePositionX - this.moveData.startPositionX;

                this.currentTransformValue =
                    this.moveData.startTransformValue + movedWidth;
            }
        },
        stopMove(event) {
            if (this.moveData.isMoveStart) {
                this.moveData.isMouseDown = this.isTouchEvent(event)
                    ? this.moveData.isMouseDown
                    : false;
                this.endTransition(event);
                this.moveData.isMoveStart = false;
            }
        },
        isTouchEvent(event) {
            return event instanceof TouchEvent;
        },
        endTransition(event) {
            let moveWidth =
                this.moveData.movePositionX - this.moveData.startPositionX;
            let activeTab =
                -1 *
                Math.sign(moveWidth) *
                Math.ceil(
                    Math.abs(moveWidth) /
                        (this.widthProductLineItem *
                            this.productItemsInLine.currentCount)
                );
            if (activeTab >= 0) {
                this.activeProductTab =
                    this.activeProductTab + activeTab >= this.countProductTab
                        ? this.countProductTab - 1
                        : this.activeProductTab + activeTab;
            } else {
                this.activeProductTab =
                    this.activeProductTab + activeTab < 0
                        ? 0
                        : this.activeProductTab + activeTab;
            }
            if (this.activeProductTab === this.countProductTab - 1) {
                this.updateTransformForLastTab();
            } else {
                this.updateTransformByActiveProductTab();
            }
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
                        this.productItemsInLine.currentCount = (this.productItemsInLine.countSmallVersion - 1);
                    }
                    break;
                case this.productWindowType.medium:
                    itemWidth =
                        (this.currentWidth - 150) /
                        this.productItemsInLine.countMediumVersion;
                    if (itemWidth > 130) {
                        this.productItemsInLine.currentCount = this.productItemsInLine.countMediumVersion;
                    } else {
                        itemWidth =
                            (this.currentWidth - 150) /
                            (this.productItemsInLine.countMediumVersion - 1);
                        this.productItemsInLine.currentCount = (this.productItemsInLine.countMediumVersion - 1);
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
        slickData() {
            let isShowNext =
                this.countProductTab !== 1 && !this.isSelectedLastTab;
            let isShowPrev =
                this.countProductTab !== 1 && !this.isSelectedFirstTab;
            return {
                isNeedShowPrevSlick: isShowPrev,
                isNeedShowNextSlick: isShowNext,
            };
        },
        isSmallVersion() {
            return this.productWindowVersion === this.productWindowType.small;
        },
        isSelectedFirstTab() {
            return this.activeProductTab === 0;
        },
        isSelectedLastTab() {
            return this.activeProductTab + 1 === this.countProductTab;
        },
        productStyleData() {
            let transitionValue = this.moveData.isMoveStart
                ? this.defaultStyleData.disableTransition
                : this.defaultStyleData.allowTransition;
            return {
                transform: `translateX(${this.currentTransformValue}px)`,
                transition: this.moveData.isMoveStart
                    ? this.defaultStyleData.disableTransition
                    : this.defaultStyleData.allowTransition,
            };
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./product_line_list_default";
@import "./product_line_list_media";
</style>