<template>
    <h1 class="person-info">
        <div class="person-info-inner">
            <div class="person-info-txt">
                <span class="person-info-title">{{personInfoData.professionPosition}}</span>
                <span
                    class="person-info-name"
                >{{personInfoData.firstNameRu}} {{personInfoData.lastNameRu}} ({{personInfoData.firstNameEn}} {{personInfoData.lastNameEn}})</span>
            </div>
        </div>
    </h1>
</template>

<script>
export default {
    props: {
        personInfoData: {
            firstNameRu: {
                type: String,
                required: true,
            },
            lastNameRu: {
                type: String,
                required: true,
            },
            firstNameEn: {
                type: String,
                required: true,
            },
            lastNameEn: {
                type: String,
                required: true,
            },
            professionPosition: {
                type: String,
                required: true,
            },
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./person_info_data_default";
@import "./person_info_data_media";
</style>