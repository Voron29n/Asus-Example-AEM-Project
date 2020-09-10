<template>
    <ul class="banner-hero-list">
        <div class="banner-hero-list-block">
            <div
                class="banner-hero-list-wrap"
                :style="componentStyle"
                @touchstart="startTouchMove"
                @touchmove="doTouchMove"
                @touchend="endTouchMove"
            >
                <li
                    class="banner-hero-list-item"
                    v-for="(heroMiddleItem, index) in heroBannerMiddleListData"
                    :key="heroMiddleItem.fileReferenceDesktop"
                    :class="{'active': index == activeImageId }"
                >
                    <VueHeroImg :hero-item="heroMiddleItem"></VueHeroImg>
                </li>
            </div>
        </div>
        <VueSlickDots
            v-if="isNeedShowSlickDots"
            :items-data="heroBannerMiddleListData"
            :active-item-id="activeImageId"
            @change-slick-dots="slickDots"
        ></VueSlickDots>
    </ul>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    components: {
        VueHeroImg: () =>
            import(
                /* webpackChunkName: "HeroBannerMiddleList" */ "../heroImage/HeroMiddleListImage"
            ),
        VueSlickDots: () =>
            import(
                /* webpackChunkName: "SlickDots" */ "@common/slick-dots/SlickDots"
            ),
    },
    props: {
        heroBannerMiddleListData: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            activeImageId: 0,
            componentStyle: {
                transform: "translateX(0px)",
                width: `${
                    window.innerWidth * this.heroBannerMiddleListData.length
                }px`,
            },
            isNeedShowNextImg: false,
            timeoutData: {
                delayTime: 5000, // 5s
                timeoutObj: undefined,
            },
            touchMoveData: {
                positionX: 0,
                touchMoveX: 0,
            },
        };
    },
    mounted() {
        this.adaptToWindow();
        this.updateActiveImg();
    },
    methods: {
        slickDots(selectIndex) {
            this.activeImageId = selectIndex;
            this.updateComponentStyle();
            this.isNeedShowNextImg = true;
        },
        updateActiveImg() {
            if (this.isNeedShowNextImg) {
                let arrayLenght = this.heroBannerMiddleListData.length - 1;
                this.activeImageId =
                    this.activeImageId === arrayLenght
                        ? 0
                        : this.activeImageId + 1;
                this.updateComponentStyle();
            } else {
                this.isNeedShowNextImg = true;
            }
            this.timeoutData.timeoutObj = setTimeout(
                this.updateActiveImg,
                this.timeoutData.delayTime
            );
        },
        adaptToWindow() {
            this.isDesktopVersionMeth();
            this.updateComponentStyle();
        },
        updateComponentStyle() {
            this.componentStyle.transform = `translateX(${
                this.isDesktopVersion
                    ? 0
                    : -window.innerWidth * this.activeImageId
            }px)`;
            this.componentStyle.width = `${
                this.isDesktopVersion
                    ? window.innerWidth
                    : window.innerWidth * this.heroBannerMiddleListData.length
            }px`;
        },
        // configureDraggingState(isDraggingStart, clientX) {
        //     this.draggingData.isDragging = isDraggingStart;
        //     this.draggingData.positionX = clientX;
        //     this.isNeedShowNextImg = false;
        //     // isDraggingStart
        //     //     ? clearTimeout(this.timeoutData.timeoutObj)
        //     //     : this.updateActiveImg();
        // },
        startTouchMove(event) {
            event.preventDefault();
            clearTimeout(this.timeoutData.timeoutObj);
            this.touchMoveData.positionX = event.touches[0].clientX;
        },
        endTouchMove(){
            this.isNeedShowNextImg = true;
            this.updateActiveImg();
        },
        doTouchMove(event) {
            console.log(event);
            let touchPosititonX = event.touches[0].clientX;
            let touchMoveX = touchPosititonX - this.touchMoveData.positionX;
            this.componentStyle.transform = `translateX(${
                -window.innerWidth * this.activeImageId + touchMoveX
            }px`;
        },
    },
    computed: {
        isNeedShowSlickDots() {
            return (
                !this.isDesktopVersion &&
                this.heroBannerMiddleListData.length > 1
            );
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./banner_images_list_default";
@import "./banner_images_list_media";
</style>