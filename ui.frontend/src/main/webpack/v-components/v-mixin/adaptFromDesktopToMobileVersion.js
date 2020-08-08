import constant from "@util/v-constant";

export const adapt = {
    data() {
        return {
            witchForMobileVersion:
                constant.heroBannerMiddle.widthForMobileVersion
        };
    },
    mounted() {
        this.adaptToWindow();
        window.addEventListener("resize", this.adaptToWindow);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.adaptToWindow);
    },
    methods: {
        adaptToWindow() {
            //need impl
        },
        isDesktopVersion() {
            return window.innerWidth > this.witchForMobileVersion
        }
    },
};
