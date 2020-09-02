<template>
    <div>
        <VueTitle :title-data="titleData"></VueTitle>
        <VueLinksGroup :links-group-data="linksGroupData"></VueLinksGroup>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "NavInfoPage" */ "./v-components/title/Title"
            ),
        VueLinksGroup: () =>
            import(
                /* webpackChunkName: "NavInfoPage" */ "./v-components/linksGroup/LinksGroup"
            ),
    },
    props: {
        title: {
            type: String,
            required: false,
        },
        linksGroup: {
            type: String,
            required: false,
            default: "",
        },
    },
    computed: {
        titleData() {
            return {
                title: this.$props.title,
            };
        },
        linksGroupData() {
            return {
                linksGroup: JSON.parse(this.$props.linksGroup),
            };
        },
    },
};
</script>

<style lang="scss">
@import "./v-style/nav-info-page_default";
@import "./v-style/nav-info-page_media";
</style>
