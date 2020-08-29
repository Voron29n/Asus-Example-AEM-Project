<template>
<div>
    <v-title :title-data="titleData"></v-title>
    <v-linksGroup :links-group-data="linksGroupData"></v-linksGroup>       
</div>
</template>

<script>
import NavInfoPage_TitleDataCmp from './v-components/title/Title'
import NavInfoPage_LinksGroupDataCmp from './v-components/linksGroup/LinksGroup'

export default {
    components: {
        "v-title": NavInfoPage_TitleDataCmp,
        "v-linksGroup": NavInfoPage_LinksGroupDataCmp,
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