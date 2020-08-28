<template>
<div>
    <v-title :title-data="titleData"></v-title>
    <v-linksGroup :links-group-data="linksGroupData"></v-linksGroup>       
</div>
</template>

<script>
import TitleData from './v-components/title/Title'
import LinksGroupData from './v-components/linksGroup/LinksGroup'

export default {
    components: {
        "v-title": TitleData,
        "v-linksGroup": LinksGroupData,
    },
    props: {
        title: {
            type: String,
            required: false,
        },
        linksGroup: {
            type: String,
            required: false,
            default: ""
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