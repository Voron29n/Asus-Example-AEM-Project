import constant from "@util/v-constant";

export const adapt = {
    data() {
        return {
            isDesktopVersion: false,
            witchForMobileVersion: constant.window.widthForMobileVersion,
            constWindowVersion: {
                small: constant.window.widthForSmallVersion,
                medium: constant.window.widthForMediumVersion,
            },
            windowVersion: null,
            currentWidth: null,
            // screenWidth: null,
            // clientWidth: null,
            // elementWidth: null,
            // availWidth: null,
        };
    },
    mounted() {
        this.currentWidth = document.body.clientWidth;
        this.adaptToWindow();
        this.getWindowVersion();
        window.addEventListener("resize", this.adaptToWindow);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.adaptToWindow);
    },
    methods: {
        // getNowWidth() {
        //     this.screenWidth = window.screen.width;
        //     this.clientWidth = document.body.clientWidth;
        //     this.elementWidth = documentElement.clientWidth;
        //     this.availWidth = window.screen.availWidth;
        // },
        adaptToWindow() {
            //default impl
            this.isDesktopVersionMeth();
            this.getWindowVersion();
            // this.getNowWidth();
        },
        isDesktopVersionMeth(maxWidth) {
            if (maxWidth !== undefined) {
                this.isDesktopVersion = document.body.clientWidth > maxWidth;
            } else {
                this.isDesktopVersion = document.body.clientWidth > this.witchForMobileVersion;
            }
            return this.isDesktopVersion;
        },
        getWindowVersion() {
            this.currentWidth = document.body.clientWidth;
            if (this.$data.currentWidth <= this.constWindowVersion.small) {
                return (this.windowVersion = "small");
            } else if (
                this.$data.currentWidth > this.constWindowVersion.small &&
                this.$data.currentWidth <= this.constWindowVersion.medium
            ) {
                return (this.windowVersion = "medium");
            } else if (this.$data.currentWidth > this.constWindowVersion.medium) {
                return (this.windowVersion = "large");
            }
        },
    },
};