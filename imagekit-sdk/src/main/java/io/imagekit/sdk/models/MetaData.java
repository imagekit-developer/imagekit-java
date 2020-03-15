package io.imagekit.sdk.models;

import com.google.gson.JsonObject;

import java.util.List;

public class MetaData {
    private float height;
    private float width;
    private float size;
    private String format;
    private boolean hasColorProfile;
    private float quality;
    private float density;
    private boolean hasTransparency;
    private String pHash;
    EXIFObject exif;


    // Getter Methods

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getSize() {
        return size;
    }

    public String getFormat() {
        return format;
    }

    public boolean getHasColorProfile() {
        return hasColorProfile;
    }

    public float getQuality() {
        return quality;
    }

    public float getDensity() {
        return density;
    }

    public boolean getHasTransparency() {
        return hasTransparency;
    }

    public String getPHash() {
        return pHash;
    }

    public EXIFObject getExif() {
        return exif;
    }

    // Setter Methods

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setHasColorProfile(boolean hasColorProfile) {
        this.hasColorProfile = hasColorProfile;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public void setHasTransparency(boolean hasTransparency) {
        this.hasTransparency = hasTransparency;
    }

    public void setPHash(String pHash) {
        this.pHash = pHash;
    }

    public void setExif(EXIFObject exifObject) {
        this.exif = exifObject;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "height=" + height +
                ", width=" + width +
                ", size=" + size +
                ", format='" + format + '\'' +
                ", hasColorProfile=" + hasColorProfile +
                ", quality=" + quality +
                ", density=" + density +
                ", hasTransparency=" + hasTransparency +
                ", pHash='" + pHash + '\'' +
                ", EXIF=" + exif +
                '}';
    }

    public class EXIFObject {
        private ImageObject image;
        private Thumbnail thumbnail;
        private Exif exif;
        private GPS gps;
        private Interoperability interoperability;
        private JsonObject makernote;

        public EXIFObject() {
        }

        public ImageObject getImage() {
            return image;
        }

        public void setImage(ImageObject image) {
            this.image = image;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Exif getExif() {
            return exif;
        }

        public void setExif(Exif exif) {
            this.exif = exif;
        }

        public GPS getGps() {
            return gps;
        }

        public void setGps(GPS gps) {
            this.gps = gps;
        }

        public Interoperability getInteroperability() {
            return interoperability;
        }

        public void setInteroperability(Interoperability interoperability) {
            this.interoperability = interoperability;
        }

        public JsonObject getMakernote() {
            return makernote;
        }

        public void setMakernote(JsonObject makernote) {
            this.makernote = makernote;
        }

        @Override
        public String toString() {
            return "EXIFObject{" +
                    "image=" + image +
                    ", thumbnail=" + thumbnail +
                    ", exif=" + exif +
                    ", gps=" + gps +
                    ", interoperability=" + interoperability +
                    ", makernote=" + makernote +
                    '}';
        }
    }

    public class ImageObject{
        private String Make;
        private String Model;
        private int Orientation;
        private int XResolution;
        private int YResolution;
        private int ResolutionUnit;
        private String Software;
        private String ModifyDate;
        private int YCbCrPositioning;
        private int ExifOffset;
        private int GPSInfo;

        public ImageObject() {
        }

        public String getMake() {
            return Make;
        }

        public void setMake(String make) {
            Make = make;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String model) {
            Model = model;
        }

        public int getOrientation() {
            return Orientation;
        }

        public void setOrientation(int orientation) {
            Orientation = orientation;
        }

        public int getXResolution() {
            return XResolution;
        }

        public void setXResolution(int XResolution) {
            this.XResolution = XResolution;
        }

        public int getYResolution() {
            return YResolution;
        }

        public void setYResolution(int YResolution) {
            this.YResolution = YResolution;
        }

        public int getResolutionUnit() {
            return ResolutionUnit;
        }

        public void setResolutionUnit(int resolutionUnit) {
            ResolutionUnit = resolutionUnit;
        }

        public String getSoftware() {
            return Software;
        }

        public void setSoftware(String software) {
            Software = software;
        }

        public String getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(String modifyDate) {
            ModifyDate = modifyDate;
        }

        public int getYCbCrPositioning() {
            return YCbCrPositioning;
        }

        public void setYCbCrPositioning(int YCbCrPositioning) {
            this.YCbCrPositioning = YCbCrPositioning;
        }

        public int getExifOffset() {
            return ExifOffset;
        }

        public void setExifOffset(int exifOffset) {
            ExifOffset = exifOffset;
        }

        public int getGPSInfo() {
            return GPSInfo;
        }

        public void setGPSInfo(int GPSInfo) {
            this.GPSInfo = GPSInfo;
        }

        @Override
        public String toString() {
            return "ImageObject{" +
                    "Make='" + Make + '\'' +
                    ", Model='" + Model + '\'' +
                    ", Orientation=" + Orientation +
                    ", XResolution=" + XResolution +
                    ", YResolution=" + YResolution +
                    ", ResolutionUnit=" + ResolutionUnit +
                    ", Software='" + Software + '\'' +
                    ", ModifyDate='" + ModifyDate + '\'' +
                    ", YCbCrPositioning=" + YCbCrPositioning +
                    ", ExifOffset=" + ExifOffset +
                    ", GPSInfo=" + GPSInfo +
                    '}';
        }
    }

    public class Thumbnail{
        private int Compression;
        private int XResolution;
        private int YResolution;
        private int ResolutionUnit;
        private int ThumbnailOffset;
        private int ThumbnailLength;

        public Thumbnail() {
        }

        public int getCompression() {
            return Compression;
        }

        public void setCompression(int compression) {
            Compression = compression;
        }

        public int getXResolution() {
            return XResolution;
        }

        public void setXResolution(int XResolution) {
            this.XResolution = XResolution;
        }

        public int getYResolution() {
            return YResolution;
        }

        public void setYResolution(int YResolution) {
            this.YResolution = YResolution;
        }

        public int getResolutionUnit() {
            return ResolutionUnit;
        }

        public void setResolutionUnit(int resolutionUnit) {
            ResolutionUnit = resolutionUnit;
        }

        public int getThumbnailOffset() {
            return ThumbnailOffset;
        }

        public void setThumbnailOffset(int thumbnailOffset) {
            ThumbnailOffset = thumbnailOffset;
        }

        public int getThumbnailLength() {
            return ThumbnailLength;
        }

        public void setThumbnailLength(int thumbnailLength) {
            ThumbnailLength = thumbnailLength;
        }

        @Override
        public String toString() {
            return "Thumbnail{" +
                    "Compression=" + Compression +
                    ", XResolution=" + XResolution +
                    ", YResolution=" + YResolution +
                    ", ResolutionUnit=" + ResolutionUnit +
                    ", ThumbnailOffset=" + ThumbnailOffset +
                    ", ThumbnailLength=" + ThumbnailLength +
                    '}';
        }
    }

    public class Exif{
        private double ExposureTime;
        private double FNumber;
        private int ExposureProgram;
        private int ISO;
        private String ExifVersion;
        private String DateTimeOriginal;
        private String CreateDate;
        private double ShutterSpeedValue;
        private double ApertureValue;
        private int ExposureCompensation;
        private int MeteringMode;
        private int Flash;
        private int FocalLength;
        private String SubSecTime;
        private String SubSecTimeOriginal;
        private String SubSecTimeDigitized;
        private String FlashpixVersion;
        private int ColorSpace;
        private int ExifImageWidth;
        private int ExifImageHeight;
        private int InteropOffset;
        private double FocalPlaneXResolution;
        private double FocalPlaneYResolution;
        private int FocalPlaneResolutionUnit;
        private int CustomRendered;
        private int ExposureMode;
        private int WhiteBalance;
        private int SceneCaptureType;

        public Exif() {
        }

        public double getExposureTime() {
            return ExposureTime;
        }

        public void setExposureTime(double exposureTime) {
            ExposureTime = exposureTime;
        }

        public double getFNumber() {
            return FNumber;
        }

        public void setFNumber(double FNumber) {
            this.FNumber = FNumber;
        }

        public int getExposureProgram() {
            return ExposureProgram;
        }

        public void setExposureProgram(int exposureProgram) {
            ExposureProgram = exposureProgram;
        }

        public int getISO() {
            return ISO;
        }

        public void setISO(int ISO) {
            this.ISO = ISO;
        }

        public String getExifVersion() {
            return ExifVersion;
        }

        public void setExifVersion(String exifVersion) {
            ExifVersion = exifVersion;
        }

        public String getDateTimeOriginal() {
            return DateTimeOriginal;
        }

        public void setDateTimeOriginal(String dateTimeOriginal) {
            DateTimeOriginal = dateTimeOriginal;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String createDate) {
            CreateDate = createDate;
        }

        public double getShutterSpeedValue() {
            return ShutterSpeedValue;
        }

        public void setShutterSpeedValue(double shutterSpeedValue) {
            ShutterSpeedValue = shutterSpeedValue;
        }

        public double getApertureValue() {
            return ApertureValue;
        }

        public void setApertureValue(double apertureValue) {
            ApertureValue = apertureValue;
        }

        public int getExposureCompensation() {
            return ExposureCompensation;
        }

        public void setExposureCompensation(int exposureCompensation) {
            ExposureCompensation = exposureCompensation;
        }

        public int getMeteringMode() {
            return MeteringMode;
        }

        public void setMeteringMode(int meteringMode) {
            MeteringMode = meteringMode;
        }

        public int getFlash() {
            return Flash;
        }

        public void setFlash(int flash) {
            Flash = flash;
        }

        public int getFocalLength() {
            return FocalLength;
        }

        public void setFocalLength(int focalLength) {
            FocalLength = focalLength;
        }

        public String getSubSecTime() {
            return SubSecTime;
        }

        public void setSubSecTime(String subSecTime) {
            SubSecTime = subSecTime;
        }

        public String getSubSecTimeOriginal() {
            return SubSecTimeOriginal;
        }

        public void setSubSecTimeOriginal(String subSecTimeOriginal) {
            SubSecTimeOriginal = subSecTimeOriginal;
        }

        public String getSubSecTimeDigitized() {
            return SubSecTimeDigitized;
        }

        public void setSubSecTimeDigitized(String subSecTimeDigitized) {
            SubSecTimeDigitized = subSecTimeDigitized;
        }

        public String getFlashpixVersion() {
            return FlashpixVersion;
        }

        public void setFlashpixVersion(String flashpixVersion) {
            FlashpixVersion = flashpixVersion;
        }

        public int getColorSpace() {
            return ColorSpace;
        }

        public void setColorSpace(int colorSpace) {
            ColorSpace = colorSpace;
        }

        public int getExifImageWidth() {
            return ExifImageWidth;
        }

        public void setExifImageWidth(int exifImageWidth) {
            ExifImageWidth = exifImageWidth;
        }

        public int getExifImageHeight() {
            return ExifImageHeight;
        }

        public void setExifImageHeight(int exifImageHeight) {
            ExifImageHeight = exifImageHeight;
        }

        public int getInteropOffset() {
            return InteropOffset;
        }

        public void setInteropOffset(int interopOffset) {
            InteropOffset = interopOffset;
        }

        public double getFocalPlaneXResolution() {
            return FocalPlaneXResolution;
        }

        public void setFocalPlaneXResolution(double focalPlaneXResolution) {
            FocalPlaneXResolution = focalPlaneXResolution;
        }

        public double getFocalPlaneYResolution() {
            return FocalPlaneYResolution;
        }

        public void setFocalPlaneYResolution(double focalPlaneYResolution) {
            FocalPlaneYResolution = focalPlaneYResolution;
        }

        public int getFocalPlaneResolutionUnit() {
            return FocalPlaneResolutionUnit;
        }

        public void setFocalPlaneResolutionUnit(int focalPlaneResolutionUnit) {
            FocalPlaneResolutionUnit = focalPlaneResolutionUnit;
        }

        public int getCustomRendered() {
            return CustomRendered;
        }

        public void setCustomRendered(int customRendered) {
            CustomRendered = customRendered;
        }

        public int getExposureMode() {
            return ExposureMode;
        }

        public void setExposureMode(int exposureMode) {
            ExposureMode = exposureMode;
        }

        public int getWhiteBalance() {
            return WhiteBalance;
        }

        public void setWhiteBalance(int whiteBalance) {
            WhiteBalance = whiteBalance;
        }

        public int getSceneCaptureType() {
            return SceneCaptureType;
        }

        public void setSceneCaptureType(int sceneCaptureType) {
            SceneCaptureType = sceneCaptureType;
        }

        @Override
        public String toString() {
            return "Exif{" +
                    "ExposureTime=" + ExposureTime +
                    ", FNumber=" + FNumber +
                    ", ExposureProgram=" + ExposureProgram +
                    ", ISO=" + ISO +
                    ", ExifVersion='" + ExifVersion + '\'' +
                    ", DateTimeOriginal='" + DateTimeOriginal + '\'' +
                    ", CreateDate='" + CreateDate + '\'' +
                    ", ShutterSpeedValue=" + ShutterSpeedValue +
                    ", ApertureValue=" + ApertureValue +
                    ", ExposureCompensation=" + ExposureCompensation +
                    ", MeteringMode=" + MeteringMode +
                    ", Flash=" + Flash +
                    ", FocalLength=" + FocalLength +
                    ", SubSecTime='" + SubSecTime + '\'' +
                    ", SubSecTimeOriginal='" + SubSecTimeOriginal + '\'' +
                    ", SubSecTimeDigitized='" + SubSecTimeDigitized + '\'' +
                    ", FlashpixVersion='" + FlashpixVersion + '\'' +
                    ", ColorSpace=" + ColorSpace +
                    ", ExifImageWidth=" + ExifImageWidth +
                    ", ExifImageHeight=" + ExifImageHeight +
                    ", InteropOffset=" + InteropOffset +
                    ", FocalPlaneXResolution=" + FocalPlaneXResolution +
                    ", FocalPlaneYResolution=" + FocalPlaneYResolution +
                    ", FocalPlaneResolutionUnit=" + FocalPlaneResolutionUnit +
                    ", CustomRendered=" + CustomRendered +
                    ", ExposureMode=" + ExposureMode +
                    ", WhiteBalance=" + WhiteBalance +
                    ", SceneCaptureType=" + SceneCaptureType +
                    '}';
        }
    }

    public class GPS{
        private List<Integer> GPSVersionID;

        public GPS() {
        }

        public List<Integer> getGPSVersionID() {
            return GPSVersionID;
        }

        public void setGPSVersionID(List<Integer> GPSVersionID) {
            this.GPSVersionID = GPSVersionID;
        }

        @Override
        public String toString() {
            return "GPS{" +
                    "GPSVersionID=" + GPSVersionID +
                    '}';
        }
    }

    public class Interoperability{
        private String InteropIndex;
        private String InteropVersion;

        public Interoperability() {
        }

        public String getInteropIndex() {
            return InteropIndex;
        }

        public void setInteropIndex(String interopIndex) {
            InteropIndex = interopIndex;
        }

        public String getInteropVersion() {
            return InteropVersion;
        }

        public void setInteropVersion(String interopVersion) {
            InteropVersion = interopVersion;
        }

        @Override
        public String toString() {
            return "Interoperability{" +
                    "InteropIndex='" + InteropIndex + '\'' +
                    ", InteropVersion='" + InteropVersion + '\'' +
                    '}';
        }
    }
}
